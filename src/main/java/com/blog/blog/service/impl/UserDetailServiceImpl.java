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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;


@Component
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User byUserName = userService.findByUserName(username);

        if (byUserName == null){
            throw new UsernameNotFoundException("用户名不存在");
        }

        ArrayList<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        List<Role> roles = userService.findyRolesByUser(byUserName);
        Iterator<Role> iterator = roles.iterator();
        while (iterator.hasNext()){
            grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_"+iterator.next().getRoleName()));
        }

        UserDetails userDetails = new UserDetails() {
            @Override
            public Collection<? extends GrantedAuthority> getAuthorities() {
                return grantedAuthorities;
            }

            @Override
            public String getPassword() {
                return byUserName.getPassword();
            }

            @Override
            public String getUsername() {
                return byUserName.getUserName();
            }

            @Override
            public boolean isAccountNonExpired() {
                return true;
            }

            @Override
            public boolean isAccountNonLocked() {
                return byUserName.getFlag() != 3;
            }

            @Override
            public boolean isCredentialsNonExpired() {
                return true;
            }

            @Override
            public boolean isEnabled() {
                return byUserName.getFlag() == 0;
            }
        };

        return userDetails;
    }
}
