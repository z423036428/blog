package com.blog.blog.service;

import com.blog.blog.module.Role;
import com.blog.blog.module.User;

import java.util.List;

public interface UserService{

    public User findByUserName(String username);

    public List<Role> findyRolesByUser(User user);

    public User register(User user);
}
