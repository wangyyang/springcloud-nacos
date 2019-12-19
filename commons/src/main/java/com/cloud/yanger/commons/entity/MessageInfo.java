package com.cloud.yanger.commons.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

@Data
public class MessageInfo {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer sender;
    private String title;
    private String content;
    private Date createTime;
    private Integer status;
    private Integer type;
    private String pushUrl;
    private Integer userType;
    private Integer sendCount;
    private Integer readCount;
    private Integer allPsnUser;
    private Integer allEnpUser;
}
