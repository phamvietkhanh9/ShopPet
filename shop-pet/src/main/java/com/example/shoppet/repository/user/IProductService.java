package com.example.shoppet.repository.user;

import com.example.shoppet.dto.ProductsDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IProductService {
    public ProductsDto GetProductByID(long id);

    public List<ProductsDto> GetProductByIDCategory(int id);
}
