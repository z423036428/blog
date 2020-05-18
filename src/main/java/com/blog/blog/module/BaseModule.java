package com.blog.blog.module;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseModule {
    //最后更新时间
    private String lastUpdateTime;
    //创建时间
    private String createTime;
    //修改人
    private String editor;
    //创建人
    private String creator;
    //版本号
    private int version;

}
