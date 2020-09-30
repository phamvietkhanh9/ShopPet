package com.example.shoppet.controller;

import com.example.shoppet.repository.user.HomeServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.PostConstruct;

@Controller
public class BaseController {
    @Autowired
    HomeServiceImp _homeServiceImp;

    public ModelAndView _mvShare = new ModelAndView();
    @PostConstruct
    public ModelAndView Init () {
        _mvShare.addObject("menus", _homeServiceImp.GetDataMenus());
        return _mvShare;
    }
}
