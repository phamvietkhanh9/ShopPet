package com.example.shoppet.repository.user;

import com.example.shoppet.dto.CartDto;
import java.util.HashMap;

import org.springframework.stereotype.Service;

@Service
public interface ICartService {
    public HashMap<Long, CartDto> AddCart(long id, HashMap<Long, CartDto> cart);
    public HashMap<Long, CartDto> EditCart(long id, int quanty, HashMap<Long, CartDto> cart);
    public HashMap<Long, CartDto> DeleteCart(long id, HashMap<Long, CartDto> cart);
    public int TotalQuanty(HashMap<Long, CartDto> cart);
    public double TotalPrice(HashMap<Long, CartDto> cart);
}