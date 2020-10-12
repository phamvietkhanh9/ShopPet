package com.example.shoppet.dao.user;

import com.example.shoppet.controller.BaseController;
import com.example.shoppet.entity.MapperUsers;
import com.example.shoppet.entity.Users;
import com.example.shoppet.entity.admin.AppUser;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class UserDao extends  BaseDao {

//    public int AddAccount(AppUser appUser){
//        StringBuffer  sql = new StringBuffer();
//        sql.append("INSERT ");
//        sql.append("INTO `app_user` ");
//        sql.append("( ");
//        sql.append("    `USER_NAME`, ");
//        sql.append("    `ENCRYTED_PASSWORD`, ");
//        sql.append("    `ENABLED` ");
//        sql.append(") ");
//        sql.append("    VALUES ");
//        sql.append("    ( ");
//        sql.append("        '"+appUser.getUserName()+"', ");
//        sql.append("        '"+appUser.getEncrytedPassword()+"', ");
//        sql.append("        '"+1+"' ");
//        sql.append("    )");
//        int insert = _jdbcTemplate.update(sql.toString());
//        return insert;
//    }


//    public Users GetAccount(Users user){
//        String sql = "SELECT * FROM users WHERE user = '"+user.getUser()+"'";
//        Users rs = _jdbcTemplate.queryForObject(sql, new MapperUsers());
//        return rs;
//    }

}
