package com.example.shoppet.dto;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapperOrderDemo implements RowMapper<Order> {
    public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
        Order order = new Order();
        order.setId(rs.getInt("id"));
        order.setUser(rs.getString("user"));
        order.setPhone(rs.getString("phone"));
        order.setDisplay_name(rs.getString("display_name"));
        order.setAddress(rs.getString("address"));
        order.setTotal(rs.getDouble("total"));
        order.setQuanty(rs.getInt("quanty"));
        order.setNote(rs.getString("note"));
        order.setName_product(rs.getString("name_product"));
        return order;
    }
}
