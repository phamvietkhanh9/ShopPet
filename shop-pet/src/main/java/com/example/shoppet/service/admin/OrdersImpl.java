package com.example.shoppet.service.admin;

import com.example.shoppet.dao.user.OrderDao;
import com.example.shoppet.dto.ProductsDto;
import com.example.shoppet.entity.user.OrdersCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdersImpl  {
    @Autowired
    private OrderDao orderDao;

    public int addOrder(OrdersCart ordersCart ) {
            return orderDao.AddOrder(ordersCart);
    }
}
