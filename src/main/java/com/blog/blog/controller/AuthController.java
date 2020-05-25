package com.blog.blog.controller;

import com.blog.blog.module.User;
import com.blog.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
public class AuthController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String loginPage(){
        return "/login.html";
    }

    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public String registerPage(){
        System.out.println("registerPage");
        return "/register.html";
    }

    @RequestMapping(value = "/register.do",method = RequestMethod.POST)
    public String doRegister(User user){
        User register = userService.register(user);
        if(register == null){
            return "/register?error=true";
        }

        return "/login";
    }

}
