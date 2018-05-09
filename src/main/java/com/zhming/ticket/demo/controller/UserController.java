package com.zhming.ticket.demo.controller;

import com.zhming.ticket.repository.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/testAdminRole",method = RequestMethod.GET)
   public String testAdminRole(){
        return "Role:ADMIN";
    }

    @PreAuthorize("hasRole('USER')")
    @RequestMapping(value = "/testUserRole",method = RequestMethod.GET)
    public String testUserRole(){
        return "Role:USER";
    }
}

