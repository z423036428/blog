package com.blog.blog.service.impl;

import com.blog.blog.module.*;
import com.blog.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;


@Component
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;
    @Autowired
    private HttpSession session;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User byUserName = userService.findByUserName(username);

        if (byUserName == null){
            throw new UsernameNotFoundException("用户名不存在");
        }
        ArrayList<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        List<Role> roles = userService.findyRolesByUser(byUserName);
        List<String> roleIds = new ArrayList<>();
        Iterator<Role> iterator = roles.iterator();
        while (iterator.hasNext()){
            Role next = iterator.next();
            roleIds.add(next.getRoleId());
            grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_"+next.getRoleName()));
        }

        UserInfo userDetails = new UserInfo(grantedAuthorities, byUserName,roleIds);
        session.setAttribute("USER_INFO", userDetails);

        return userDetails;
    }
}
