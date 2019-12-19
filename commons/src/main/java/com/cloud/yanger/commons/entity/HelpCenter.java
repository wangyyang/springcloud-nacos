package com.cloud.yanger.commons.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

@Data
public class HelpCenter {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer type;
    private String title;
    private String content;
    private String cover;
    private Integer enable;
    private Integer recommend;
    private Integer lookOver;
    private Integer sysUserId;
    private Integer modifier;
    private Date modifyTime;
    private Integer userType;
    private Date createTime;
}
