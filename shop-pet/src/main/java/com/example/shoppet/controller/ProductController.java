package com.example.shoppet.controller;

import com.example.shoppet.dto.ProductsDto;
import com.example.shoppet.repository.admin.ProductModel;
import com.example.shoppet.repository.user.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Calendar;
import java.util.Optional;
import javax.validation.Valid;

@Controller
public class ProductController extends BaseController{

    private static String UPLOADED_FOLDER = "target/classes/static/user/img";

    @Autowired
    private ProductModel productModel;

    @Autowired
    private IProductService _productService;

    @RequestMapping(value = { "chi-tiet-san-pham/{id}" })
    public ModelAndView Index(@PathVariable long id,Model model, @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int limit) {
        Page<ProductsDto> pagination = productModel.findProductsByStatus(1, PageRequest.of(page - 1, limit));
        model.addAttribute("pagination", pagination);
        model.addAttribute("page", page);
        model.addAttribute("limit", limit);
        _mvShare.setViewName("user/product");
        _mvShare.addObject("product", _productService.GetProductByID(id));
        int idCategory = _productService.GetProductByID(id).getId_category();
        _mvShare.addObject("productByIDCategory", _homeServiceImp.GetDataProductsNew());
        return _mvShare;
    }


//    @RequestMapping(path = "/product/list", method = RequestMethod.GET)
 //   public String getListProduct(Model model, @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int limit) {
//        Page<ProductsDto> pagination = productModel.findProductsByStatus(1, PageRequest.of(page - 1, limit));
//        model.addAttribute("pagination", pagination);
//        model.addAttribute("page", page);
//        model.addAttribute("limit", limit);
//        model.addAttribute("datetime", Calendar.getInstance().getTime());
//        model.addAttribute("products", _homeServiceImp.GetDataProducts());
//        return "/admin/product/product-list";
//    }
    @RequestMapping(path = "/product/list", method = RequestMethod.GET)
    public ModelAndView getListProduct( Model model, @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int limit) {
        _mvShare.setViewName("/admin/product/product-list");;
        Page<ProductsDto> pagination = productModel.findProductsByStatus(1, PageRequest.of(page - 1, limit));
        _mvShare.addObject("pagination", pagination);
        _mvShare.addObject("page", page);
        _mvShare.addObject("limit", limit);
        _mvShare.addObject("products", _homeServiceImp.GetDataProductsA());
        _mvShare.addObject("datetime", Calendar.getInstance().getTime());
        return _mvShare;
    }



    @RequestMapping(path = "/product/create", method = RequestMethod.GET)
    public String createProduct(@ModelAttribute ProductsDto p) {
        return "/admin/product/product-form";
    }


    @RequestMapping(path = "/product/create", method = RequestMethod.POST)
    public String saveProduct(@Valid ProductsDto product, BindingResult result,
                              @RequestParam("myFile") MultipartFile myFile) {
        product.setImg("_");
//        new ProductValidator().validate(product, result);
        if (result.hasErrors()) {
            return "admin/product/product-form";
        }
        try {
            Path path = Paths.get(UPLOADED_FOLDER + myFile.getOriginalFilename());
            Files.write(path, myFile.getBytes());
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
        product.setImg("/" + myFile.getOriginalFilename());
        productModel.save(product);
        return "redirect:/product/list";
    }

    @RequestMapping(path = "/product/edit/{id}", method = RequestMethod.GET)
    public String editProduct(@PathVariable int id, Model model) {
        Optional<ProductsDto> optionalProduct = productModel.findById(id);
        if (optionalProduct.isPresent()) {
            model.addAttribute("product", optionalProduct.get());
            return "admin/product/product-form";
        } else {
            return "not-found";
        }
    }

    @RequestMapping(path = "/product/edit/{id}", method = RequestMethod.POST)
    public String updateProduct(@PathVariable int id,@Valid ProductsDto product, BindingResult result, Model model){
        Optional<ProductsDto> optionalProduct = productModel.findById(id);
        if (optionalProduct.isPresent()) {
            if (result.hasErrors()) {
                return "admin/product/product-form";
            }
            productModel.save(product);
            return "redirect:/product/list";
        } else {
            return "not-found";
        }
    }



}