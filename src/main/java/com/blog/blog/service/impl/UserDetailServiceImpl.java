package com.blog.blog.service.impl;

import com.blog.blog.mapper.RoleMapper;
import com.blog.blog.mapper.UserMapper;
import com.blog.blog.mapper.UserRoleRelationMapper;
import com.blog.blog.module.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    UserMapper userMapper;
    @Autowired
    UserRoleRelationMapper userRoleRelationMapper;
    @Autowired
    RoleMapper roleMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUserNameEqualTo(username);
        List<User> users = userMapper.selectByExample(userExample);
        UserRoleRelationExample userRoleRelationExample = new UserRoleRelationExample();
        UserRoleRelationExample.Criteria criteria1 = userRoleRelationExample.createCriteria();
        criteria1.andUserIdEqualTo(users.get(0).getUserId());
        List<UserRoleRelation> userRoleRelations = userRoleRelationMapper.selectByExample(userRoleRelationExample);
        ArrayList<String> roles = new ArrayList<String>();
        for(UserRoleRelation userRoleRelation : userRoleRelations){
            RoleExample roleExample = new RoleExample();
            roleExample.createCriteria().andRoleIdEqualTo(userRoleRelation.getRoleId());
            String roleName = roleMapper.selectByExample(roleExample).get(0).getRoleName();
            roles.add(roleName);
        }

        UserDetails userDetails = new UserDetails() {
            /**
             * 获取权限信息列表
             * @return
             */
            @Override
            public Collection<? extends GrantedAuthority> getAuthorities() {
                ArrayList<SimpleGrantedAuthority> simpleGrantedAuthorities = new ArrayList<SimpleGrantedAuthority>();
                for(String roleName : roles){
                    SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(roleName);
                    simpleGrantedAuthorities.add(simpleGrantedAuthority);
                }
                return simpleGrantedAuthorities;
            }

            /**
             * 获取密码
             * @return
             */
            @Override
            public String getPassword() {
                return users.get(0).getPassword();
            }

            /**
             * 获取用户名
             * @return
             */
            @Override
            public String getUsername() {
                return users.get(0).getUserName();
            }

            /**
             * 验证账号是否过期
             * @return
             */
            @Override
            public boolean isAccountNonExpired() {
                return false;
            }

            /**
             * 验证账户是否锁定
             * @return
             */
            @Override
            public boolean isAccountNonLocked() {
                return false;
            }

            /**
             * 验证认证信息是否过期
             * @return
             */
            @Override
            public boolean isCredentialsNonExpired() {
                return false;
            }

            /**
             * 验证用户是否被禁用
             * @return
             */
            @Override
            public boolean isEnabled() {
                Integer flag = users.get(0).getFlag();
                return flag != 0;
            }
        };
        return userDetails;
    }
}
