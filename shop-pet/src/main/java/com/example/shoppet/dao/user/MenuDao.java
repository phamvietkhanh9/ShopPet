package com.example.shoppet.dao.user;

import com.example.shoppet.entity.user.MapperMenus;
import com.example.shoppet.entity.user.Menus;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MenuDao extends BaseDao{
    public List<Menus> GetDataMenus(){
        List<Menus> list = new ArrayList<Menus>();
        String sql = "SELECT * FROM menus";
        list = _jdbcTemplate.query(sql, new MapperMenus());
        return list;
    }
}