package com.example.shoppet.dao.admin;

import com.example.shoppet.dao.user.BaseDao;
import com.example.shoppet.entity.admin.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

@Repository
@Transactional
public class AppUserDao extends BaseDao {
    @Autowired
    private EntityManager entityManager;

    public AppUser findUserAccount(String userName) {
        try {
            String sql = "Select e from " + AppUser.class.getName() + " e " //
                    + " Where e.userName = :userName ";

            Query query = entityManager.createQuery(sql, AppUser.class);
            query.setParameter("userName", userName);

            return (AppUser) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }


    public int AddAccount(AppUser appUser){
        StringBuffer  sql = new StringBuffer();
        sql.append("INSERT ");
        sql.append("INTO `app_user` ");
        sql.append("( ");
        sql.append("    `user_name`, ");
        sql.append("    `encryted_password`, ");
        sql.append("    `enabled` ");
        sql.append(") ");
        sql.append("    VALUES ");
        sql.append("    ( ");
        sql.append("        '"+appUser.getUserName()+"', ");
        sql.append("        '"+appUser.getEncrytedPassword()+"', ");
        sql.append("        '"+1+"' ");
        sql.append("    )");
        int insert = _jdbcTemplate.update(sql.toString());
        return insert;
    }

}