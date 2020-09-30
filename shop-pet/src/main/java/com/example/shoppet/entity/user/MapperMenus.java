package com.example.shoppet.entity.user;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapperMenus implements RowMapper<Menus> {

    public Menus mapRow(ResultSet rs, int rowNum) throws SQLException {
        Menus menus = new Menus();
        menus.setId(rs.getInt("id"));
        menus.setName(rs.getString("name"));
        menus.setUrl(rs.getString("url"));
        return menus;
    }
}