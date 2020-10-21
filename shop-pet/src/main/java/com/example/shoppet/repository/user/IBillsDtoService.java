package com.example.shoppet.repository.user;

import com.example.shoppet.dto.BillsDto;
import com.example.shoppet.dto.CartDto;
import org.springframework.stereotype.Service;

import java.util.HashMap;
@Service
public interface IBillsDtoService {
    public HashMap<Long, BillsDto> DeleteCart(long id, HashMap<Long, BillsDto> bills);
}
