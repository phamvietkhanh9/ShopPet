package com.example.shoppet.controller;

import com.example.shoppet.entity.Users;
import com.example.shoppet.entity.admin.AppUser;
import com.example.shoppet.service.admin.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class UserContronller extends  BaseController{

//    @Autowired
//    private AccountServiceImpl accountService;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @RequestMapping(value ={ "/dang-ky","/register"}, method = RequestMethod.GET)
    public ModelAndView DangKy(){
        _mvShare.setViewName("user/register");
        _mvShare.addObject("appUser",new AppUser());
        return _mvShare;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView CreateAcc(@ModelAttribute AppUser appUser){
        userDetailsService.addAccount(appUser);
        _mvShare.setViewName("user/register");
        return _mvShare;
    }

//    @RequestMapping(value = "/register", method = RequestMethod.POST)
//    public ModelAndView CreateAcc(@ModelAttribute("user") AppUser appUser){
//        int count = userDetailsService.addAccount(appUser);
//        if (count > 0 ){
//            _mvShare.addObject("status","Dang Ki Thanh Cong");
//        }else{
//            _mvShare.addObject("status","Dang Ki That Bai");
//        }
//        _mvShare.setViewName("user/register");
//        return _mvShare;
//    }

//    @RequestMapping(value ={ "/dang-nhap"}, method = RequestMethod.POST)
//    public ModelAndView DangNhap(HttpSession session, @ModelAttribute("user") Users users){
//        boolean check = userDetailsService.CheckAccount(users);
//        if (check){
//            _mvShare.setViewName("redirect:/home");
//        }else {
//            _mvShare.addObject("statusLogin","Dang nhap that bai");
//        }
//        return _mvShare;
//    }

}
