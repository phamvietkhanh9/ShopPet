package com.example.shoppet.controller;
import com.example.shoppet.dto.CartDto;
import com.example.shoppet.entity.admin.AppUser;
import com.example.shoppet.entity.user.BillDetail;
import com.example.shoppet.entity.user.Bills;
import com.example.shoppet.repository.user.BillsServiceImpl;
import com.example.shoppet.repository.user.CartServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;


@Controller
public class OrderController extends BaseController {

    @Autowired
    private CartServiceImpl cartService = new CartServiceImpl();
//
//    @Autowired
//    private BillsRepository billsRepository ;

    @Autowired
    private BillsServiceImpl billsService = new BillsServiceImpl();

    @RequestMapping(value = {"/checkout","/gio-hang2"},method = RequestMethod.GET)
    private ModelAndView CheckOut(HttpSession session, HttpServletRequest request){
        HashMap<Long, CartDto> cart = (HashMap<Long, CartDto>) session.getAttribute("Cart");
        Bills bills = new Bills();
        _mvShare.setViewName("user/cartUser");
        _mvShare.addObject("Cart", cart);
        _mvShare.addObject("TotalPriceCart", cartService.TotalPrice(cart));
        AppUser loginInfo = (AppUser)session.getAttribute("LoginInfo");


        _mvShare.addObject("bills",bills);
        return _mvShare;
    }

    @RequestMapping(value = {"/checkout"},method = RequestMethod.POST)
    private String CheckOutBills(HttpSession session, HttpServletRequest request,@ModelAttribute("bills")Bills bill){
//        bill.setQuanty(Integer.parseInt((String)session.getAttribute("TotalQuantyCart")));
//        bill.setTotal(Double.parseDouble((String)session.getAttribute("TotalPriceCart")));
        if (billsService.AddBills(bill) > 0){
            HashMap<Long,CartDto> carts = (HashMap<Long, CartDto>)session.getAttribute("Cart");
            billsService.AddBillsDetail(carts);
        }
        session.removeAttribute("Cart");
        return "redirect:/gio-hang";
    }


    //admin
    @RequestMapping(value = {"/orderAdmin"}, method = RequestMethod.GET)
    public ModelAndView OrderAdmin() {
        _mvShare.setViewName("admin/orderAdmin");;
        _mvShare.addObject("order",_homeServiceImp.GetDataOrder());
        return _mvShare;
    }

}
