package com.blog.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/admin")
@Controller
public class AdminController {

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(){
        return "/admin/login.html";
    }

    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String index(){
        return "/admin/index.html";
    }
}
