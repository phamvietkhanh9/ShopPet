package com.example.shoppet.repository.user;

import com.example.shoppet.entity.user.Bills;
import org.springframework.stereotype.Service;

@Service
public interface IOrderService {
    public Bills GetBillsByID(long id);
}
