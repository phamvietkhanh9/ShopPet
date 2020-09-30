package com.example.shoppet.entity.user;

import com.example.shoppet.entity.Slides;
import org.springframework.jdbc.core.RowMapper;

import javax.swing.tree.TreePath;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MapperCategorys implements RowMapper<Categorys> {
    @Override
    public Categorys mapRow(ResultSet rs, int i) throws SQLException {
        Categorys categorys = new Categorys();
        categorys.setId(rs.getInt("id"));
        categorys.setName(rs.getString("name"));
        categorys.setDescription(rs.getString("description"));
        return categorys;
    }
}