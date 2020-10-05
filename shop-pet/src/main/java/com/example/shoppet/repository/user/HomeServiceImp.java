package com.example.shoppet.repository.user;

import com.example.shoppet.dao.user.CategoryDao;
import com.example.shoppet.dao.user.MenuDao;
import com.example.shoppet.dao.user.ProductDao;
import com.example.shoppet.dao.user.SlidesDao;
import com.example.shoppet.dto.CartDto;
import com.example.shoppet.dto.ProductsDto;
import com.example.shoppet.entity.Slides;
import com.example.shoppet.entity.user.Categorys;
import com.example.shoppet.entity.user.Menus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomeServiceImp implements IHomeService {
    @Autowired
    private SlidesDao slidesDao;
    @Autowired
    private CategoryDao categoryDao;
    @Autowired
    private MenuDao menuDao;
    @Autowired
    private ProductDao productDao;

    @Override
    public List<Slides> GetDataSlide() {
        return slidesDao.GetDataSlide();
    }

    public  List<Categorys> GetDatacategorys(){
        return categoryDao.GetDataCategorys();
    }
    public List<Menus> GetDataMenus() {
        return menuDao.GetDataMenus();
    }


    public List<ProductsDto> GetDataProducts() {
        List<ProductsDto> listProducts = productDao.GetDataProducts();
        return listProducts;
    }

    public List<ProductsDto> GetDataProductsA() {
        List<ProductsDto> listProducts = productDao.GetDataProductsA();
        return listProducts;
    }

    public List<ProductsDto> GetDataAllProducts() {
        List<ProductsDto> listProducts = productDao.GetDataProducts();
        //    listProducts.get(); //.getId_color();
        return listProducts;
    }
    public List<ProductsDto> GetDataProductsNew() {
        List<ProductsDto> listProducts = productDao.GetDataProductsNew();
        //    listProducts.get(); //.getId_color();
        return listProducts;
    }
    public List<ProductsDto> GetDataProductsNew1() {
        List<ProductsDto> listProducts = productDao.GetDataProductsNew();
        //    listProducts.get(); //.getId_color();
        return listProducts;
    }
}
