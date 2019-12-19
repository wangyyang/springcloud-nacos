package com.cloud.yanger.commons.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

@Data
public class SystemNotice {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer userType;
    private Integer noticeType;
    private String title;
    private String imageUrl;
    private String intro;
    private String content;
    private String linkAddress;
    private Integer status;
    private Integer lookOver;
    private Integer sysUserId;
    private Date createTime;
    private Integer modifier;
    private Date modifyTime;

}
