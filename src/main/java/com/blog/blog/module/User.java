package com.blog.blog.module;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User extends BaseModule{
    //id
    private Long id;
    //userId (随机生成，加密解密)
    private String userId;
    //用户名（登录名）
    private String userName;
    //昵称
    private String nickName;
    //登录密码(不可逆加密)
    private String password;
    //用户邮箱
    private String mail;
    //用户权限
    private Long roleId;


}
