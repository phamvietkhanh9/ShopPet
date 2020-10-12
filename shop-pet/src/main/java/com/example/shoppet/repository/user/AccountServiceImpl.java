//package com.example.shoppet.repository.user;
//
//import com.example.shoppet.dao.admin.AppRoleDao;
//import com.example.shoppet.dao.admin.AppUserDao;
//import com.example.shoppet.dao.user.UserDao;
//import com.example.shoppet.entity.Users;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCrypt;
//import org.springframework.stereotype.Service;
//
//@Service
//public class AccountServiceImpl implements IAccountService{
//
//    @Autowired
//    UserDao userDao = new UserDao();
//
//
////    public int addAccount(Users users){
////        users.setPassword(BCrypt.hashpw(users.getPassword(),BCrypt.gensalt(12)));
////        return userDao.AddAccount(users);
////    }
////
////    public boolean CheckAccount(Users users){
////        String pass = users.getPassword();
////        users =  userDao.GetAccount(users);
////        if (users != null){
////            if (BCrypt.checkpw(pass ,users.getPassword())){
////                return true;
////            }else {
////                return false;
////            }
////        }
////        return false;
////    }
//}
