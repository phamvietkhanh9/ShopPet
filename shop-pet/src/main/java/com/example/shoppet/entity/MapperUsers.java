package com.example.shoppet.entity;

import com.example.shoppet.entity.user.Menus;
import org.springframework.jdbc.core.RowMapper;

import javax.swing.tree.TreePath;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MapperUsers  implements RowMapper<Users> {

    public Users mapRow(ResultSet rs, int rowNum) throws SQLException {
        Users users = new Users();
       users.setId(rs.getLong("id"));
       users.setUser(rs.getString("user"));
        users.setUser(rs.getString("password"));
        users.setUser(rs.getString("display_name"));
        users.setUser(rs.getString("address"));
        return users;
    }
}
