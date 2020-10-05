package com.example.shoppet.repository.admin;

import com.example.shoppet.dto.ProductsDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProductModel extends PagingAndSortingRepository<ProductsDto, Integer> {

    Page<ProductsDto> findProductsByPrice(int price, Pageable pageable);

    Page<ProductsDto> findProductsByStatus(int status, Pageable pageable);

    Page<ProductsDto> findByName(String name, Pageable pageable);
}
