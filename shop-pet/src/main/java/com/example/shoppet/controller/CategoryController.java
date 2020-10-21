package com.example.shoppet.controller;

import com.example.shoppet.dto.PaginatesDto;
import com.example.shoppet.dto.ProductsDto;
import com.example.shoppet.repository.admin.ProductModel;
import com.example.shoppet.repository.user.CategoryServiceImpl;
import com.example.shoppet.repository.user.PaginateServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Calendar;
import java.util.List;

@Controller
public class CategoryController extends BaseController {

    @Autowired
    private CategoryServiceImpl categoryService;

    @Autowired
    private ProductModel productModel;

    @Autowired
    private PaginateServiceImpl paginateService;


    private int totalProductsPage = 30;

    @RequestMapping(path = "/san-pham/{id}")
    public ModelAndView Product(@PathVariable String id) {
        _mvShare.setViewName("user/products");
        int totalData = categoryService.GetAllProductsByID(Integer.parseInt(id)).size();
        PaginatesDto paginateInfo = paginateService.GetInfoPaginates(totalData, totalProductsPage, 1);
        _mvShare.addObject("idCategory", id);
        _mvShare.addObject("paginateInfo", paginateInfo);
        _mvShare.addObject("productsPaginate", categoryService.GetDataProductsPaginate(Integer.parseInt(id), paginateInfo.getStart(), totalProductsPage));
        return _mvShare;
    }

    @RequestMapping(value = "/san-pham/{id}/{currentPage}")
    public ModelAndView Product(@PathVariable String id, @PathVariable String currentPage) {
        _mvShare.setViewName("user/products");
        int totalData = categoryService.GetAllProductsByID(Integer.parseInt(id)).size();
        PaginatesDto paginateInfo = paginateService.GetInfoPaginates(totalData, totalProductsPage, Integer.parseInt(currentPage));
        _mvShare.addObject("idCategory", id);
        _mvShare.addObject("paginateInfo", paginateInfo);
        _mvShare.addObject("productsPaginate", categoryService.GetDataProductsPaginate(Integer.parseInt(id) ,paginateInfo.getStart(), totalProductsPage));
        return _mvShare;
    }

//    @RequestMapping(value = {"/pages/2"}, method = RequestMethod.GET)
//    public ModelAndView ListProduct() {
//        _mvShare.setViewName("user/listProducts");;
//        _mvShare.addObject("products",_homeServiceImp.GetDataProducts());
//        return _mvShare;
//    }

    @RequestMapping(value = {"/pages/2"}, method = RequestMethod.GET)
    public ModelAndView ListProduct(Model model, @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int limit) {
        Page<ProductsDto> pagination = productModel.findProductsByStatus(1, PageRequest.of(page - 1, limit));
        model.addAttribute("pagination", pagination);
        model.addAttribute("page", page);
        model.addAttribute("limit", limit);
        _mvShare.setViewName("user/listProducts");;
        _mvShare.addObject("products",_homeServiceImp.GetDataProducts());
        return _mvShare;
    }



}
