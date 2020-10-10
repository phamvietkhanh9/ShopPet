package com.example.shoppet.repository.user;

import com.example.shoppet.entity.user.OrdersCart;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<OrdersCart, Long> {
}
