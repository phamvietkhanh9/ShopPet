package com.example.shoppet.repository.user;

import com.example.shoppet.dao.user.BillsDao;
import com.example.shoppet.entity.user.Bills;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IOrderServiceImpl implements IOrderService {

    @Autowired
    BillsDao billsDao = new BillsDao();

    public Bills GetBillsByID(long id) {
        List<Bills> listProducts = billsDao.GetBillByID(id);
        return listProducts.get(0);
    }

}
