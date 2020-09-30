package com.example.shoppet.repository.user;

import com.example.shoppet.dao.user.ProductDao;
import com.example.shoppet.dto.ProductsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    ProductDao productDao = new ProductDao();

    public ProductsDto GetProductByID(long id) {
        List<ProductsDto> listProducts = productDao.GetProductByID(id);
        return listProducts.get(0);
    }

    public List<ProductsDto> GetProductByIDCategory(int id) {
        return productDao.GetAllProductsByID(id);
    }

}