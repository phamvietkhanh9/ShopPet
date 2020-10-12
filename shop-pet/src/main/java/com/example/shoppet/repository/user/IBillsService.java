package com.example.shoppet.repository.user;

import com.example.shoppet.dto.CartDto;
import com.example.shoppet.entity.user.Bills;
import com.example.shoppet.entity.user.OrdersCart;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public interface IBillsService {
    public int AddBills(Bills bill);
    public void AddBillsDetail(HashMap<Long, CartDto> carts);
}
