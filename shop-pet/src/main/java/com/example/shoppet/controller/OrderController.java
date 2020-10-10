package com.example.shoppet.controller;
import com.example.shoppet.dao.user.OrderDao;
import com.example.shoppet.dto.CartDto;
import com.example.shoppet.entity.user.OrdersCart;
import com.example.shoppet.repository.user.CartServiceImpl;
import com.example.shoppet.repository.user.OrderRepository;
import com.example.shoppet.service.admin.OrdersImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;


@Controller
public class OrderController extends BaseController {

    @Autowired
    private CartServiceImpl cartService = new CartServiceImpl();

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderDao orderDao;
    @Autowired
    private OrdersImpl ordersimp;

        @RequestMapping(value = {"/gio-hang2"})
    public Object IndexCart(HttpSession session) {
        HashMap<Long, CartDto> cart = (HashMap<Long, CartDto>) session.getAttribute("Cart");
        if (cart == null){
            _mvShare.addObject("order",new OrdersCart());
            return "redirect:/";
        }else {
            _mvShare.addObject("Cart", cart);
            _mvShare.setViewName("user/cartUser");
            _mvShare.addObject("TotalPriceCart", cartService.TotalPrice(cart));
            _mvShare.addObject("order",new OrdersCart());
            return _mvShare;
        }

    }

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
    //xóa contact
    @RequestMapping(value = "/deleteOrder",method = RequestMethod.GET)
    public String deleteOrder(@RequestParam("id") Long orderId, Model model){
        orderRepository.deleteById(orderId);
        return "redirect:/";
    }

    @RequestMapping(value = "/saveOrder",method = RequestMethod.POST)
    public String saveOrder(@ModelAttribute OrdersCart ordersCart,HttpSession session ){
        HashMap<Long, CartDto> cart = (HashMap<Long, CartDto>) session.getAttribute("Cart");
            ordersimp.addOrder(ordersCart);
            return "redirect:/";

    }

}
