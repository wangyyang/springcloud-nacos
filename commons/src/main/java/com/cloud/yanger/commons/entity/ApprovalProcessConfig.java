package com.cloud.yanger.commons.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

@Data
public class ApprovalProcessConfig {
    @TableId(type = IdType.AUTO)
    private int id;
    private Integer sysUserId;
    private Integer type;
    private Integer level;
    private Integer finalLevel;
    private Integer createUser;
    private Date createTime;
    private Integer modifier;
    private Date modifyTime;
}
