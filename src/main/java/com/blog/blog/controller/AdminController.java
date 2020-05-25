package com.blog.blog.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@RequestMapping(value = "/admin")
@Controller
public class AdminController {

    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String index(){
        return "/admin/index.html";
    }



}
