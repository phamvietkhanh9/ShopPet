package com.example.shoppet.dao.user;



import com.example.shoppet.dto.Order;
import com.example.shoppet.entity.user.Bills;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class OrderDao extends BaseDao {

    public int AddOrder(Order order ){
        StringBuffer  sql = new StringBuffer();
        sql.append("INSERT ");
        sql.append("INTO `order_demo` ");
        sql.append("( ");
        sql.append("    `user`, ");
        sql.append("    `phone`, ");
        sql.append("    `display_name`, ");
        sql.append("     `address`, ");
        sql.append("     `total`, ");
        sql.append("     `quanty`, ");
        sql.append("     `name_product`, ");
        sql.append("    `note` ");
        sql.append(") ");
        sql.append("    VALUES ");
        sql.append("    ( ");
        sql.append("        '"+order.getUser()+"', ");
        sql.append("        '"+order.getPhone()+"', ");
        sql.append("        '"+order.getDisplay_name()+"', ");
        sql.append("        '"+order.getAddress()+"', ");
        sql.append("        '"+order.getTotal()+"', ");
        sql.append("        '"+order.getQuanty()+"', ");
        sql.append("        '"+order.getName_product()+"', ");
        sql.append("        '"+order.getNote()+"' ");
        sql.append("    )");
        int insert = _jdbcTemplate.update(sql.toString());
        return insert;
    };


}
