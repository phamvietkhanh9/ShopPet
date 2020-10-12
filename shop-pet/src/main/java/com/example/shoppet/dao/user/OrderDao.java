//package com.example.shoppet.dao.user;
//
//
//import com.example.shoppet.dto.ProductsDto;
//import com.example.shoppet.entity.user.OrdersCart;
//import com.example.shoppet.entity.user.OrdersCartDetail;
//import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;
//
//@Repository
//@Transactional
//public class OrderDao extends BaseDao {
//
//    public int AddBills(OrdersCart ordersCart ){
//        StringBuffer  sql = new StringBuffer();
//        sql.append("INSERT ");
//        sql.append("INTO `orderscart` ");
//        sql.append("( ");
//        sql.append("    `Address`, ");
//        sql.append("    `NameProduct`, ");
//        sql.append("    `name`, ");
//        sql.append("     `phone`, ");
//        sql.append("    `email` ");
//        sql.append(") ");
//        sql.append("    VALUES ");
//        sql.append("    ( ");
//        sql.append("        '"+ordersCart.getAddress()+"', ");
//        sql.append("        '"+ordersCart.getNameProduct()+"', ");
//        sql.append("        '"+ordersCart.getName()+"', ");
//        sql.append("        '"+ordersCart.getPhone()+"', ");
//        sql.append("        '"+ordersCart.getEmail()+"' ");
//        sql.append("    )");
//        int insert = _jdbcTemplate.update(sql.toString());
//        return insert;
//    }
//
//    public long GetIDLastBills(){
//        StringBuilder sql = new StringBuilder();
//        sql.append(" SELECT MAX(id) FROM orderscart;");
//        long id = _jdbcTemplate.queryForObject(sql.toString(),new Object[] {}, Long.class);
//        return  id;
//    }
//    public int AddBillsDetail(OrdersCartDetail ordersCartDetail){
//        StringBuffer  sql = new StringBuffer();
//        sql.append("INSERT INTO `orderscartdetail` ");
//        sql.append("( ");
//        sql.append("     `id_product`, ");
//        sql.append("     `id_OrdersCart`, ");
//        sql.append("     `quanty`, ");
//        sql.append("     `total` ");
//        sql.append(") ");
//        sql.append(" VALUES ");
//        sql.append("( ");
//        sql.append(" 	`id`, ");
//        sql.append("	`id_OrdersCart`, ");
//        sql.append("	`quanty`, ");
//        sql.append("	`total` ");
//        sql.append(") ");
//        int insert = _jdbcTemplate.update(sql.toString());
//        return insert;
//    }
//
//
//}
