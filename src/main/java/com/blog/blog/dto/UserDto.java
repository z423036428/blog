package com.blog.blog.dto;

import com.blog.blog.module.User;

public class UserDto {
    private Long id;
    private String userId;
    private String userName;
    private String nickName;
    private String createTime;
    private String lastUpdateTime;
    private String creator;
    private String editor;
    private String roleName;

    public UserDto(Long id, String userId, String userName, String nickName, String createTime, String lastUpdateTime, String creator, String editor, String roleName) {
        this.id = id;
        this.userId = userId;
        this.userName = userName;
        this.nickName = nickName;
        this.createTime = createTime;
        this.lastUpdateTime = lastUpdateTime;
        this.creator = creator;
        this.editor = editor;
        this.roleName = roleName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(String lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
