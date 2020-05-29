package com.blog.blog.Util;

import com.blog.blog.dto.UserDto;
import com.blog.blog.module.User;

public class DtoFormatUtil {

    public static UserDto userDtoFormat(User user,String roleName,String roleId){

        UserDto userDto = new UserDto(user.getId(), user.getUserId(), user.getUserName(), user.getNickName(), user.getCreateTime(), user.getLastUpdateTime(), user.getCreator(), user.getEditor(), roleName,roleId);
        return userDto;
    }

}
