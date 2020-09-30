package com.example.shoppet.repository.user;

import com.example.shoppet.dto.ProductsDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ICategoryService {
    public List<ProductsDto> GetAllProductsByID(int id);
}
