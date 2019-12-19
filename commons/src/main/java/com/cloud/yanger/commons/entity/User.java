package com.cloud.yanger.commons.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

@Data
public class User {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String phone;
    private String email;
    private String password;
    private String headerImg;
    private String name;
    private Integer gender;
    private String birthday;
    private Integer realNameAuth;
    private String invitationCode;
    private Integer talentType;
    private Integer userType;
    private Integer status;
    private Integer accountStatus;
    private String imUserId;
    private String imFacId;
    private String imPassword;
    private Date createTime;
    private Date lastLoginTime;
    private Integer iflag;
    private Integer invitedTalentsNum;
}
