package com.blog.blog.service;

import com.blog.blog.dto.UserDto;
import com.blog.blog.module.Role;
import com.blog.blog.module.User;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface UserService{

    public User findByUserName(String username);

    public List<Role> findyRolesByUser(User user);

    public User register(User user);

    public PageInfo<UserDto> findUsersByPage(Integer currentPageNum, Integer pageSize);
}
