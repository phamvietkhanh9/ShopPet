package com.example.shoppet.dao.user;


import com.example.shoppet.dto.ProductsDto;
import com.example.shoppet.entity.user.OrdersCart;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class OrderDao extends BaseDao {

    public int AddOrder(OrdersCart ordersCart ){
        StringBuffer  sql = new StringBuffer();
        sql.append("INSERT ");
        sql.append("INTO `orders_cart` ");
        sql.append("( ");
        sql.append("    `address`, ");
        sql.append("    `name_product`, ");
        sql.append("    `name`, ");
        sql.append("     `phone`, ");
        sql.append("    `email` ");
        sql.append(") ");
        sql.append("    VALUES ");
        sql.append("    ( ");
        sql.append("        '"+ordersCart.getAddress()+"', ");
        sql.append("        '"+ordersCart.getNameProduct()+"', ");
        sql.append("        '"+ordersCart.getName()+"', ");
        sql.append("        '"+ordersCart.getPhone()+"', ");
        sql.append("        '"+ordersCart.getEmail()+"' ");
        sql.append("    )");
        int insert = _jdbcTemplate.update(sql.toString());
        return insert;
    }

}
