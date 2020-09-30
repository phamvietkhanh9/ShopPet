package com.example.shoppet.repository.user;

import com.example.shoppet.dao.user.ProductDao;
import com.example.shoppet.dto.ProductsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryServiceImpl implements ICategoryService{

    @Autowired
    private ProductDao productsDao;

    public List<ProductsDto> GetAllProductsByID(int id) {
        return productsDao.GetAllProductsByID(id);
    }

    public List<ProductsDto> GetDataProductsPaginate(int id, int start, int totalPage) {
        return productsDao.GetDataProductsPaginate(id, start, totalPage);
    }

}

