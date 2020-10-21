package com.example.shoppet.dto;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BillsDtoMapper implements RowMapper<BillsDto> {
    public BillsDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        BillsDto billsDto = new BillsDto();
        billsDto.setId(rs.getInt("id"));
        billsDto.setUser(rs.getString("user"));
        billsDto.setPhone(rs.getString("phone"));
        billsDto.setDisplay_name(rs.getString("display_name"));
        billsDto.setAddress(rs.getString("address"));
        billsDto.setTotal(rs.getDouble("total"));
        billsDto.setQuanty(rs.getInt("quanty"));
        billsDto.setNote(rs.getString("note"));
        billsDto.setId_bills(rs.getLong("id_product"));
        billsDto.setId_product(rs.getLong("id_bills"));
        billsDto.setName(rs.getString("name"));
        return billsDto;
    }
}
