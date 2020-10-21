package com.example.shoppet.dao.user;

import com.example.shoppet.dto.ProductsDto;
import com.example.shoppet.dto.ProductsDtoMapper;
import com.example.shoppet.entity.user.BillDetail;
import com.example.shoppet.entity.user.Bills;
import com.example.shoppet.entity.user.Categorys;
import com.example.shoppet.entity.user.MapperCategorys;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class BillsDao extends BaseDao {

    public int AddBills(Bills bill ){
        StringBuffer  sql = new StringBuffer();
        sql.append("INSERT ");
        sql.append("INTO `bills` ");
        sql.append("( ");
        sql.append("    `user`, ");
        sql.append("    `phone`, ");
        sql.append("    `display_name`, ");
        sql.append("     `address`, ");
        sql.append("     `total`, ");
        sql.append("     `quanty`, ");
        sql.append("    `note` ");
        sql.append(") ");
        sql.append("    VALUES ");
        sql.append("    ( ");
        sql.append("        '"+bill.getUser()+"', ");
        sql.append("        '"+bill.getPhone()+"', ");
        sql.append("        '"+bill.getDisplay_name()+"', ");
        sql.append("        '"+bill.getAddress()+"', ");
        sql.append("        '"+bill.getTotal()+"', ");
        sql.append("        '"+bill.getQuanty()+"', ");
        sql.append("        '"+bill.getNote()+"' ");
        sql.append("    )");
        int insert = _jdbcTemplate.update(sql.toString());
        return insert;
    };

    public long GetIDLastBills(){
        StringBuilder sql = new StringBuilder();
        sql.append(" SELECT MAX(id) FROM bills;");
        long id = _jdbcTemplate.queryForObject(sql.toString(), new Object[] {}, Long.class);
        return  id;
    };

    public int AddBillsDetail(BillDetail billDetail){
        StringBuffer  sql = new StringBuffer();
        sql.append("INSERT INTO `billdetail` ");
        sql.append("( ");
        sql.append("     `id_product`, ");
        sql.append("     `id_bills`, ");
        sql.append("     `quanty`, ");
        sql.append("     `total` ");
        sql.append(") ");
        sql.append(" VALUES ");
        sql.append("( ");
        sql.append("        '"+billDetail.getId_product()+"', ");
        sql.append("        '"+billDetail.getId_bills()+"', ");
        sql.append("        '"+billDetail.getQuanty()+"', ");
        sql.append("        '"+billDetail.getTotal()+"' ");
        sql.append(") ");
        int insert = _jdbcTemplate.update(sql.toString());
        return insert;
    }

    public List<Bills> GetDataBills(){
        List<Bills> list = new ArrayList<Bills>();
        String sql = "SELECT * FROM bills";
        list = _jdbcTemplate.query(sql, new MapperBills());
        return list;
    }



    public List<Bills> GetBillByID(long id) {
        String sql = SqlBillsByID(id);
        List<Bills> listProduct = _jdbcTemplate.query(sql, new MapperBills());
        return listProduct;
    }

    public Bills FindBillsByID(long id) {
        String sql = SqlBillsByID(id);
        Bills Bills = _jdbcTemplate.queryForObject(sql, new MapperBills());
        return Bills;
    }
    private String SqlBillsByID(long id) {
        StringBuffer  sql = new StringBuffer();
        sql.append("SELECT * FROM `bills` ");
        sql.append("WHERE id = " + id + " ");
        return sql.toString();
    }

}
