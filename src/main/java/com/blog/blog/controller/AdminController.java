package com.blog.blog.controller;


import com.blog.blog.common.ServerResponse;
import com.blog.blog.dto.UserDto;
import com.blog.blog.module.User;
import com.blog.blog.module.UserInfo;
import com.blog.blog.service.UserService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping(value = "/admin")
@Controller
public class AdminController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String index(Model model){
        UserInfo principal = (UserInfo) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("user", principal.getUser());
        model.addAttribute("url", "admin/home");
        return "/admin/index.html";
    }

    @RequestMapping(value = "/userManager",method = RequestMethod.GET)
    public String userManager(String pageNum,String pageSize,Model model){
        UserInfo principal = (UserInfo) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("user", principal.getUser());
        model.addAttribute("url", "admin/user");

        PageInfo<UserDto> usersByPage = userService.findUsersByPage(Integer.valueOf(pageNum), Integer.valueOf(pageSize));
        List<UserDto> list = usersByPage.getList();
        model.addAttribute("users", list);

        return "/admin/index.html";
    }

    @RequestMapping(value = "/user.edit",method = RequestMethod.PATCH)
    @ResponseBody
    public ServerResponse userEdit(String roleId, String userId){
        return userService.updateUser(roleId, userId);
    }

    @RequestMapping(value = "/user.delete",method = RequestMethod.DELETE)
    @ResponseBody
    public ServerResponse userDel(String id){
        return userService.delUserById(id);
    }

    @RequestMapping(value = "/personInfo",method = RequestMethod.GET)
    public String personInfo(Model model){
        UserInfo principal = (UserInfo) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("user", principal.getUser());
        model.addAttribute("url", "admin/personInfo");

        return "/admin/index.html";
    }

}
