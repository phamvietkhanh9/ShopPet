package com.example.shoppet.repository.user;

import com.example.shoppet.dao.user.BillsDao;
import com.example.shoppet.dto.CartDto;
import com.example.shoppet.entity.user.BillDetail;
import com.example.shoppet.entity.user.Bills;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class BillsServiceImpl implements IBillsService{
    @Autowired
    private BillsDao billsDao;

    @Override
    public int AddBills(Bills bill) {
        return billsDao.AddBills(bill);
    }

    @Override
    public void AddBillsDetail(HashMap<Long, CartDto> carts) {

        long idBills = billsDao.GetIDLastBills();

        for (Map.Entry<Long,CartDto> itemCart : carts.entrySet()){
            BillDetail billDetail = new BillDetail();
            billDetail.setId_bills(idBills);
            billDetail.setId_product(itemCart.getValue().getProduct().getId_product());
            billDetail.setQuanty(itemCart.getValue().getQuanty());
            billDetail.setTotal(itemCart.getValue().getTotalPrice());
            billsDao.AddBillsDetail(billDetail);
        }

    }
}
