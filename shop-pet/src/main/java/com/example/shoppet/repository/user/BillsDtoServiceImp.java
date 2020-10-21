package com.example.shoppet.repository.user;

import com.example.shoppet.dao.user.BillsDao;
import com.example.shoppet.dto.BillsDto;
import com.example.shoppet.dto.CartDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
@Service
public class BillsDtoServiceImp implements IBillsDtoService{

    @Autowired
    private BillsDao billsDao;

    public HashMap<Long, BillsDto> DeleteCart(long id, HashMap<Long, BillsDto> bill) {
        return billsDao.DeleteBill(id, bill);
    }
}
