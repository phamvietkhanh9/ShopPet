package com.example.shoppet.controller;
import com.example.shoppet.dto.BillsDto;
import com.example.shoppet.dto.CartDto;
import com.example.shoppet.dto.Order;
import com.example.shoppet.entity.admin.AppUser;
import com.example.shoppet.entity.admin.CustomErrorType;
import com.example.shoppet.entity.user.Bills;
import com.example.shoppet.repository.admin.BillModel;
import com.example.shoppet.repository.user.BillsDtoServiceImp;
import com.example.shoppet.repository.user.BillsServiceImpl;
import com.example.shoppet.repository.user.CartServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Optional;

import org.springframework.data.domain.PageRequest;



@Controller
public class OrderController extends BaseController {

    @Autowired
    private CartServiceImpl cartService = new CartServiceImpl();
//
//    @Autowired
//    private BillsRepository billsRepository ;
    @Autowired
    private BillModel billModel;

    @Autowired
    private BillsServiceImpl billsService = new BillsServiceImpl();

    @Autowired
    private BillsDtoServiceImp billsDtoServiceImp;

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


//    @RequestMapping(value = {"/checkout"},method = RequestMethod.POST)
//    private String CheckOutBills(HttpSession session, HttpServletRequest request,@ModelAttribute("bills") Order Order){
////        bill.setQuanty(Integer.parseInt((String)session.getAttribute("TotalQuantyCart")));
////        bill.setTotal(Double.parseDouble((String)session.getAttribute("TotalPriceCart")));
//        if (billsService.AddBills(Order) > 0){
//            HashMap<Long,CartDto> carts = (HashMap<Long, CartDto>)session.getAttribute("Cart");
//            billsService.AddBillsDetail(carts);
//        }
//        session.removeAttribute("Cart");
//        return "redirect:/gio-hang";
//    }



    //admin
//    @RequestMapping(value = {"/orderAdmin"}, method = RequestMethod.GET)
//    public ModelAndView OrderAdmin( Model model, @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int limit) {
//        _mvShare.addObject("order",_homeServiceImp.GetDataOrder());
//        Page<BillsDto> pagination1 = billModel.findBillsDtoBy(1, PageRequest.of(page - 1, limit));
//        _mvShare.addObject("pagination", pagination1);
//        _mvShare.addObject("page", page);
//        _mvShare.addObject("limit", limit);
//        _mvShare.setViewName("admin/orderAdmin");;
//        return _mvShare;
//    }
//
//    @RequestMapping(value = {"/orderAdmin"}, method = RequestMethod.GET)
//    public String OrderAdmin(@ModelAttribute Model model, @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int limit) {
//        model.addAttribute("order",_homeServiceImp.GetDataOrder());
//        if (model == null){
//
//
//        }
//        Page<BillsDto> pagination = billModel.findBillsDtoBy(1, PageRequest.of(page - 1, limit));
//        model.addAttribute("pagination", pagination);
//        model.addAttribute("page", page);
//        model.addAttribute("limit", limit);
//        return "admin/orderAdmin";
//    }
    @RequestMapping(value = {"/orderAdmin"}, method = RequestMethod.GET)
    public ModelAndView OrderAdmin( Model model, @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int limit) {
        _mvShare.addObject("order",_homeServiceImp.GetDataOrder());
//        Page<BillsDto> pagination = billModel.findBillsDtoBy(1, PageRequest.of(page - 1, limit));
//        _mvShare.addObject("pagination", pagination);
//        _mvShare.addObject("page", page);
        _mvShare.addObject("limit", limit);
        _mvShare.setViewName("admin/orderAdmin");;
        return _mvShare;
    }


    @RequestMapping(path = "/endpoint/product/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable long id) {
        Optional<BillsDto> optionalProduct = billModel.findById(id);
        if (optionalProduct.isPresent()) {
            BillsDto product = optionalProduct.get();
            billModel.save(product);
            return new ResponseEntity<BillsDto>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity(new CustomErrorType("Unable to delete. Product with id " + id + " not found."),
                    HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "DeleteBills/{id}")
    public String DeleteBills(HttpServletRequest request, HttpSession session, @PathVariable long id) {
        HashMap<Long, BillsDto> bills = (HashMap<Long, BillsDto>) session.getAttribute("Bills");
          bills = billsDtoServiceImp.DeleteCart(id, bills);
//        session.setAttribute("Cart", bills);
//        session.setAttribute("TotalQuantyCart", cartService.TotalQuanty(bills));
//        session.setAttribute("TotalPriceCart", cartService.TotalPrice(bills));
        return "redirect:" + request.getHeader("Referer");
    }




}
