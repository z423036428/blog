package com.blog.blog.service.impl;

import com.blog.blog.Util.DtoFormatUtil;
import com.blog.blog.common.ResponseCode;
import com.blog.blog.common.ServerResponse;
import com.blog.blog.dto.UserDto;
import com.blog.blog.mapper.RoleMapper;
import com.blog.blog.mapper.UserMapper;
import com.blog.blog.mapper.UserRoleRelationMapper;
import com.blog.blog.module.*;
import com.blog.blog.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private UserRoleRelationMapper userRoleRelationMapper;

    /**
     * 通过username查找User，一般用于查看用户是否存在
     * @param username
     * @return
     */
    @Override
    public User findByUserName(String username) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUserNameEqualTo(username);
        criteria.andFlagEqualTo(0);
        List<User> users = userMapper.selectByExample(userExample);
        if(users == null || users.isEmpty()){
            return null;
        }
        return users.get(0);
    }

    /**
     * 通过用户获取，获取用户的所有角色
      * @param user
     * @return
     */
    @Override
    public List<Role> findyRolesByUser(User user) {

        UserRoleRelationExample userRoleRelationExample = new UserRoleRelationExample();
        userRoleRelationExample.createCriteria().andUserIdEqualTo(user.getUserId()).andFlagEqualTo(0);
        List<UserRoleRelation> userRoleRelations = userRoleRelationMapper.selectByExample(userRoleRelationExample);
        ArrayList<String> roleIds = new ArrayList<>();

        Iterator<UserRoleRelation> iterator = userRoleRelations.iterator();
        while (iterator.hasNext()){
            roleIds.add(iterator.next().getRoleId());
        }

        RoleExample roleExample = new RoleExample();
        roleExample.createCriteria().andRoleIdIn(roleIds).andFlagEqualTo(0);
        List<Role> roles = roleMapper.selectByExample(roleExample);
        return roles;
    }

    /**
     * 注册新用户，此时参数user中只有username,password,mail需要补全信息
     * @param user
     * @return
     */
    @Transactional
    @Override
    public User register(User user) {
        User byUserName = findByUserName(user.getUserName());
        if(byUserName != null){
            return null;
        }
        String currentTime = String.valueOf(new Date().getTime());
        String UID = UUID.randomUUID().toString().replace("-", "");
        user.setUserId(UID);
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        user.setNickName(UID);
        user.setEditor("Admin");
        user.setCreator("Admin");
        user.setFlag(0);
        user.setLastUpdateTime(currentTime);
        user.setCreateTime(currentTime);
        user.setVersion("0");

        userMapper.insert(user);

        UserRoleRelation userRoleRelation = new UserRoleRelation();
        userRoleRelation.setRoleId("2");
        userRoleRelation.setUserId(user.getUserId());
        userRoleRelation.setCreateTime(currentTime);
        userRoleRelation.setLastUpdateTime(currentTime);
        userRoleRelation.setCreator("Admin");
        userRoleRelation.setEditor("Admin");
        userRoleRelation.setFlag(0);
        userRoleRelation.setVersion("0");

        userRoleRelationMapper.insert(userRoleRelation);

        return user;
    }

    @Override
    public PageInfo<UserDto> findUsersByPage(Integer currentPageNum, Integer pageSize) {
        PageHelper.startPage(currentPageNum, pageSize);
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andFlagEqualTo(0);
        List<User> users = userMapper.selectByExample(userExample);
        List<UserDto> userDtos = new ArrayList<>();
        Iterator<User> iterator = users.iterator();
        while(iterator.hasNext()){
            User user = iterator.next();
            List<Role> roles = findyRolesByUser(user);
            userDtos.add(DtoFormatUtil.userDtoFormat(user,roles.get(0).getRoleName(),roles.get(0).getRoleId()));
        }

        PageInfo<UserDto> pageInfo = new PageInfo<>(userDtos);
        return pageInfo;
    }

    @Transactional
    @Override
    public ServerResponse updateUser(String roleId, String userId) {

        UserInfo userInfo = (UserInfo) (SecurityContextHolder.getContext().getAuthentication().getPrincipal());

        UserRoleRelationExample userRoleRelationExample = new UserRoleRelationExample();
        UserRoleRelationExample.Criteria criteria = userRoleRelationExample.createCriteria();
        criteria.andUserIdEqualTo(userId);
        List<UserRoleRelation> userRoleRelations = userRoleRelationMapper.selectByExample(userRoleRelationExample);
        if(userRoleRelations == null || userRoleRelations.isEmpty()){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ERROR.getCode(), "用户更新错误");
        }
        String date = String.valueOf(new Date().getTime());
        UserRoleRelation userRoleRelation = userRoleRelations.get(0);
        userRoleRelation.setLastUpdateTime(date);
        userRoleRelation.setEditor(userInfo.getUsername());
        userRoleRelation.setVersion(String.valueOf(Integer.valueOf(userRoleRelation.getVersion())+1));
        userRoleRelation.setRoleId(roleId);
        userRoleRelationMapper.updateByExample(userRoleRelation,userRoleRelationExample);
        return ServerResponse.createBySuccess("更新成功");
    }

    @Transactional
    @Override
    public ServerResponse delUserById(String id) {
        User user = new User();
        user.setId(Long.valueOf(id));
        user.setFlag(1);
        try {
            userMapper.updateByPrimaryKeySelective(user);
        }catch (Exception e){
            return ServerResponse.createByError();
        }
        return ServerResponse.createBySuccess();
    }

}
