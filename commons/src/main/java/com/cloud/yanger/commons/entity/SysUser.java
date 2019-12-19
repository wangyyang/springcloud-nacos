package com.cloud.yanger.commons.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

@Data
public class SysUser {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String nickname;
    private String phone;
    private Integer gender;
    private String headImg;
    private String password;
    private Integer type;
    private Integer status;
    private String remark;
    private String district;
    private Integer departmentId;
    private Date lastLoginTime;
    private Integer sysUserId;
    private Date createTime;
    private Integer modifier;
    private Date modifyTime;
}
