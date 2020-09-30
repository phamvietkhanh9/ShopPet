//package com.example.shoppet.repository;
//
//import com.example.shoppet.dto.ProductsDto;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.repository.PagingAndSortingRepository;
//
//import java.util.List;
//
//public interface ProductModel extends PagingAndSortingRepository<ProductsDto, Integer> {
//
//    Page<ProductsDto> findProductByStatus(int status, Pageable pageable);
//    Page<ProductsDto> findProductsByStatus(int status, Pageable pageable);
//    Page<ProductsDto> findProductsByPrice(int price, Pageable pageable);
//    Page<ProductsDto> findByName(String name, Pageable pageable);
//    Page<ProductsDto> findByNameAndPrice(String name, int price, Pageable pageable);
//    List<ProductsDto> findDistinctByName(String name);
//
//
//}