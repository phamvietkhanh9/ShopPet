package com.example.shoppet.controller;

import com.example.shoppet.dto.CartDto;
import com.example.shoppet.repository.user.CartServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

@Controller
public class CartController extends BaseController{

    @Autowired
    private CartServiceImpl cartService = new CartServiceImpl();

    @RequestMapping(value = "/gio-hang")
    public ModelAndView Index(HttpSession session) {
        HashMap<Long, CartDto> cart = (HashMap<Long, CartDto>)session.getAttribute("Cart");
        _mvShare.addObject("Cart",cart);
        _mvShare.setViewName("user/cart");
        return _mvShare;
    }


    @RequestMapping(value = "/AddCart/{id}", method = RequestMethod.GET)
    public String AddCart(HttpServletRequest request , HttpSession session, @PathVariable long id) {
        HashMap<Long, CartDto> cart = (HashMap<Long, CartDto>)session.getAttribute("Cart");
        if(cart == null) {
            cart = new HashMap<Long, CartDto>();
        }
        cart = cartService.AddCart(id, cart);
        session.setAttribute("Cart", cart);
        session.setAttribute("TotalQuantyCart", cartService.TotalQuanty(cart));
        session.setAttribute("TotalPriceCart", cartService.TotalPrice(cart));
        return "redirect:"+request.getHeader("Referer");
    }

    @RequestMapping(value = "EditCart/{id}")
    public String EditCart(HttpServletRequest request ,HttpSession session, @PathVariable long id) {
        HashMap<Long, CartDto> cart = (HashMap<Long, CartDto>)session.getAttribute("Cart");
        if(cart == null) {
            cart = new HashMap<Long, CartDto>();
        }
//		cart = cartService.EditCart(id, quanty, cart);
//		session.setAttribute("Cart", cart);
//		session.setAttribute("TotalQuantyCart", cartService.TotalQuanty(cart));
//		session.setAttribute("TotalPriceCart", cartService.TotalPrice(cart));
        return "redirect:"+request.getHeader("Referer");
    }


    @RequestMapping(value = "DeleteCart/{id}")
    public String DeleteCart(HttpServletRequest request ,HttpSession session, @PathVariable long id) {
        HashMap<Long, CartDto> cart = (HashMap<Long, CartDto>)session.getAttribute("Cart");
        if(cart == null) {
            cart = new HashMap<Long, CartDto>();
        }
        cart = cartService.DeleteCart(id, cart);
        session.setAttribute("Cart", cart);
        session.setAttribute("TotalQuantyCart", cartService.TotalQuanty(cart));
        session.setAttribute("TotalPriceCart", cartService.TotalPrice(cart));
        return "redirect:"+request.getHeader("Referer");
    }
}

