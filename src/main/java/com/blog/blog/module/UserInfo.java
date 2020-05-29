package com.blog.blog.module;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class UserInfo implements UserDetails {

    private Collection<? extends GrantedAuthority> grantedAuthorities;

    private User user;

    private List<String> currentUserRole;

    public UserInfo() {
    }

    public UserInfo(Collection<? extends GrantedAuthority> grantedAuthorities, User user,List<String> currentUserRole) {
        this.grantedAuthorities = grantedAuthorities;
        this.user = user;
        this.currentUserRole = currentUserRole;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return grantedAuthorities;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUserName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return user.getFlag() != 3;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return user.getFlag() == 0;
    }

    public Collection<? extends GrantedAuthority> getGrantedAuthorities() {
        return grantedAuthorities;
    }

    public void setGrantedAuthorities(Collection<? extends GrantedAuthority> grantedAuthorities) {
        this.grantedAuthorities = grantedAuthorities;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<String> getCurrentUserRole() {
        return currentUserRole;
    }

    public void setCurrentUserRole(List<String> currentUserRole) {
        this.currentUserRole = currentUserRole;
    }
}
