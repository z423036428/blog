package com.blog.blog.module;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Category extends BaseModule {
    //id 01/02/03/ 六位数字组成，01为一级分类ID 010000,以此类推
    private int id;
    //分类名称
    private String categoryName;
    //分类等级
    private String categoryLevel;
    //分类描述
    private String description;
}
