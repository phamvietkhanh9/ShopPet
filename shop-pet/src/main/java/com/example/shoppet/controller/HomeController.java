package com.example.shoppet.controller;

import com.example.shoppet.dto.CartDto;
import com.example.shoppet.dto.ProductsDto;
import com.example.shoppet.entity.user.Bills;
import com.example.shoppet.repository.user.CartServiceImpl;
import com.example.shoppet.repository.user.HomeServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

@Controller
public class HomeController extends BaseController {


    @Autowired
    private CartServiceImpl cartService = new CartServiceImpl();


    @RequestMapping(value = {"/", "/welcome","/home","/pages/1"}, method = RequestMethod.GET)
    public ModelAndView Index(HttpSession session){
        HashMap<Long, CartDto> cart = (HashMap<Long, CartDto>)session.getAttribute("Cart");
        _mvShare.addObject("Cart",cart);
        _mvShare.addObject("slides",_homeServiceImp.GetDataSlide());
        _mvShare.addObject("category",_homeServiceImp.GetDatacategorys());
        _mvShare.addObject("products",_homeServiceImp.GetDataProducts());
        _mvShare.addObject("order",_homeServiceImp.GetDataOrder());
        _mvShare.addObject("productsNew",_homeServiceImp.GetDataProductsNew());
        _mvShare.setViewName("user/Index");
        return _mvShare;
    }
}


