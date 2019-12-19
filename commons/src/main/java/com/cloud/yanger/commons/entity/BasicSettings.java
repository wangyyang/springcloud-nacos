package com.cloud.yanger.commons.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

@Data
public class BasicSettings {
    @TableId(type = IdType.AUTO)
    private int id;
    private String title;
    private Integer type;
    private String content;
    private Integer status;
    private Integer sysUserId;
    private Date createTime;
    private Integer modifier;
    private Date modifyTime;
}
