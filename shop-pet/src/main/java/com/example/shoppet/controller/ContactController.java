package com.example.shoppet.controller;

import com.example.shoppet.dto.CartDto;
import com.example.shoppet.entity.user.Contact;
import com.example.shoppet.repository.user.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

@Controller
public class ContactController  extends BaseController {

    @Autowired
    private ContactRepository contactRepository;



    @RequestMapping(value = { "/contact" ,"/pages/3"}, method = RequestMethod.GET)
    public String contactPage(Model model) {
        model.addAttribute("contact",new Contact());
        return "/user/contactPage";
    }

    @RequestMapping("/contactAdmin")
    public String contactAdmin(Model model){
        List<Contact> contacts = (List<Contact>) contactRepository.findAll();
        model.addAttribute("contacts",contacts);
        return "/admin/contactAdmin";
    }
    //lưu contact
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public String save(Contact contact){
        contactRepository.save(contact);
        return "redirect:/";
    }
    //xóa contact
    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    public String deleteContact(@RequestParam("id") Long contactId, Model model){
        contactRepository.deleteById(contactId);
        return "redirect:/";
    }
}
