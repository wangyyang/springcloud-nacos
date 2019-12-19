package com.cloud.yanger.commons.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

@Data
public class SysRole {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String roleCode;
    private String roleName;
    private String permission;
    private Integer state;
    private Integer sysUserId;
    private Date createTime;
    private Integer modifier;
    private Date modifyTime;
}
