package com.example.shoppet.dao.user;

import com.example.shoppet.entity.Slides;
import com.example.shoppet.entity.user.Bills;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapperBills implements RowMapper<Bills> {
    @Override
    public Bills mapRow(ResultSet rs, int i) throws SQLException {
        Bills bills = new Bills();
        bills.setId(rs.getInt("id"));
        bills.setUser(rs.getString("user"));
        bills.setPhone(rs.getString("phone"));
        bills.setDisplay_name(rs.getString("display_name"));
        bills.setAddress(rs.getString("address"));
        bills.setTotal(rs.getDouble("total"));
        bills.setQuanty(rs.getInt("quanty"));
        bills.setNote(rs.getString("note"));
        return bills;
    }
}
