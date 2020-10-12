package com.example.shoppet.controller;
import com.example.shoppet.dto.CartDto;
import com.example.shoppet.entity.admin.AppUser;
import com.example.shoppet.entity.user.Bills;
import com.example.shoppet.entity.user.OrdersCart;
import com.example.shoppet.repository.user.BillsServiceImpl;
import com.example.shoppet.repository.user.CartServiceImpl;
import com.example.shoppet.repository.user.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;


@Controller
public class OrderController extends BaseController {

    @Autowired
    private CartServiceImpl cartService = new CartServiceImpl();

    @Autowired
    private OrderRepository orderRepository;


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

        _mvShare.addObject("order", new OrdersCart());
        return _mvShare;
    }

    @RequestMapping(value = {"/checkout"},method = RequestMethod.POST)
    private String CheckOutBills(HttpSession session, HttpServletRequest request,@ModelAttribute("bills")Bills bill){
        

        if (billsService.AddBills(bill) > 0){
            HashMap<Long,CartDto> carts = (HashMap<Long, CartDto>)session.getAttribute("Cart");
            billsService.AddBillsDetail(carts);
        }
        session.removeAttribute("Cart");
        return "redirect:/gio-hang";
    }


//    @RequestMapping(value = {"/checkout","/gio-hang2"},method = RequestMethod.GET)
//    private ModelAndView CheckOut(HttpSession session, HttpServletRequest request){
//        HashMap<Long, CartDto> cart = (HashMap<Long, CartDto>) session.getAttribute("Cart");
//        Bills bills = new Bills();
//        _mvShare.addObject("Cart", cart);
//        _mvShare.addObject("TotalPriceCart", cartService.TotalPrice(cart));
//
//
//        _mvShare.setViewName("user/cartUser");
//        _mvShare.addObject("order", new OrdersCart());
//        return _mvShare;
//    }



//    @RequestMapping(value = {"/gio-hang2"})
//    public Object IndexCart(HttpSession session) {
//        HashMap<Long, CartDto> cart = (HashMap<Long, CartDto>) session.getAttribute("Cart");
//        if (cart == null){
//            _mvShare.addObject("order",new OrdersCart());
//            return "redirect:/";
//        }else {
//            _mvShare.addObject("Cart", cart);
//            _mvShare.setViewName("user/cartUser");
//            _mvShare.addObject("TotalPriceCart", cartService.TotalPrice(cart));
//            _mvShare.addObject("order",new OrdersCart());
//            return _mvShare;
//        }
//
//    }

//    @RequestMapping("/contactAdmin")
//    public String orderAdmin(Model model){
//        List<OrdersCart> ordersCarts = (List<OrdersCart>) orderRepository.findAll();
//        model.addAttribute("ordersCarts",ordersCarts);
//        return "/admin/contactAdmin";
//    }
    //lưu contact
//    @RequestMapping(value = "/saveOrder",method = RequestMethod.POST)
//    public String saveOrder(@ModelAttribute OrdersCart ordersCart,HttpSession session ){
//        HashMap<Long, CartDto> cart = (HashMap<Long, CartDto>) session.getAttribute("Cart");
//        if (ordersCart == null){
//            return "redirect:/gio-hang2";
//        }
//        else {
//            orderRepository.save(ordersCart);
//            return "redirect:/";
//        }
//    }
//
//    @RequestMapping(value = "/deleteOrder",method = RequestMethod.GET)
//    public String deleteOrder(@RequestParam("id") Long orderId, Model model){
//        orderRepository.deleteById(orderId);
//        return "redirect:/";
//    }

//    @RequestMapping(value = "/saveOrder",method = RequestMethod.POST)
//    public String saveOrder(@ModelAttribute OrdersCart ordersCart,HttpSession session ){
//        HashMap<Long, CartDto> cart = (HashMap<Long, CartDto>) session.getAttribute("Cart");
//            ordersimp.addOrder(ordersCart);
//            return "redirect:/";
//
//    }

}
