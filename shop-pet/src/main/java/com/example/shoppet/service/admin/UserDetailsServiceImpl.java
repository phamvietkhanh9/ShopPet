package com.example.shoppet.service.admin;


import com.example.shoppet.dao.admin.AppRoleDao;
import com.example.shoppet.dao.admin.AppUserDao;
import com.example.shoppet.dao.user.UserDao;
import com.example.shoppet.entity.Users;
import com.example.shoppet.entity.admin.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private AppUserDao appUserDAO;

    @Autowired
    private AppRoleDao appRoleDAO;

    @Autowired
    UserDao userDao = new UserDao();

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        AppUser appUser = this.appUserDAO.findUserAccount(userName);

        if (appUser == null) {
            System.out.println("User not found! " + userName);
            throw new UsernameNotFoundException("User " + userName + " was not found in the database");
        }

        System.out.println("Found User: " + appUser);

        // [ROLE_USER, ROLE_ADMIN,..]
        List<String> roleNames = this.appRoleDAO.getRoleNames(appUser.getUserId());

        List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
        if (roleNames != null) {
            for (String role : roleNames) {
                // ROLE_USER, ROLE_ADMIN,..
                GrantedAuthority authority = new SimpleGrantedAuthority(role);
                grantList.add(authority);
            }
        }

        UserDetails userDetails = (UserDetails) new User(appUser.getUserName(), //
                appUser.getEncrytedPassword(), grantList);

        return userDetails;
    }



    public int addAccount(AppUser appUser){
        appUser.setEncrytedPassword(BCrypt.hashpw(appUser.getEncrytedPassword(),BCrypt.gensalt(12)));
        return  appUserDAO.AddAccount(appUser);
    }

//    public boolean CheckAccount(Users user){
//        String pass = user.getPassword();
//        user =  userDao.GetAccount(user);
//        if (user != null){
//            if (BCrypt.checkpw(pass,user.getPassword())){
//                return true;
//            }else {
//                return false;
//            }
//        }
//        return false;
//    }

}