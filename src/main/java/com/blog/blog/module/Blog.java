package com.blog.blog.module;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Blog extends BaseModule {
    //id
    private long id;
    //标题
    private String title;
    //一级分类(类型ID)
    private String firstCategory;
    //二级分类（类型ID）
    private String secondCategory;
    //三级分类（类型ID）
    private String thirdCategory;
    //内容文件的地址
    private String content;
    //拥有标签的ID号，每个标签用，分割
    private String tag;
}
