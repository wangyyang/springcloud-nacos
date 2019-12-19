package com.cloud.yanger.commons.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

@Data
public class Report {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer targetId;
    private Integer type;
    private Integer reason;
    private String title;
    private String content;
    private String attachment;
    private Integer status;
    private Integer userId;
    private String userName;
    private String userPhone;
    private Date createTime;
    private Integer sysUserId;
    private String sysUserName;
    private Date sysModifyTime;
}
