package com.blog.blog.controller;

import com.blog.blog.module.User;
import org.springframework.security.config.web.servlet.SecurityMarker;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequestMapping(value = "/admin")
@Controller
public class AdminController {

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(){
        return "/admin/login.html";
    }

    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public String register(){
        return "/admin/register.html";
    }

    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String index(){
        return "/admin/index.html";
    }

    //登录
    @PostMapping("/userLogin")
    public String doLogin(@RequestParam String username, @RequestParam String password){
        System.out.println("返回值是》》"+username+"---->"+password);
        return "/admin/index.html";
    }

    //注册
    @PostMapping("/userRegister")
    public String doRegister(@RequestParam String username, @RequestParam String password1, @RequestParam String password2){
        System.out.println("返回值是》》"+username+"---->"+password1+"---->"+password2);
        return "/admin/login.html";
    }

}
