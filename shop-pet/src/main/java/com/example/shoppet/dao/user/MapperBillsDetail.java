package com.example.shoppet.dao.user;

import com.example.shoppet.entity.user.BillDetail;
import com.example.shoppet.entity.user.Bills;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapperBillsDetail implements RowMapper<BillDetail> {
    @Override
    public BillDetail mapRow(ResultSet rs, int i) throws SQLException {
        BillDetail billDetail = new BillDetail();
        billDetail.setId(rs.getInt("id"));
        billDetail.setId_bills(rs.getLong("id_product"));
        billDetail.setId_product(rs.getLong("id_bills"));
        billDetail.setQuanty(rs.getInt("quanty"));
        billDetail.setTotal(rs.getDouble("total"));
        return billDetail;
    }
}