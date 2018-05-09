package com.zhming.ticket.demo.controller;

import com.zhming.ticket.repository.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
//@RequestMapping("/")
public class HomeController {


    @Autowired
    UserService userService;
    @RequestMapping
    public String index(){
        return "/home";
    }

    //@RequestMapping("/login")
    public String login(){
        return userService.findByUsername("admin").toString();
    }
}
