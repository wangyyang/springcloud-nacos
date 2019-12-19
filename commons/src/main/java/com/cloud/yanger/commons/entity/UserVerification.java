package com.cloud.yanger.commons.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

@Data
public class UserVerification {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer userId;
    private String name;
    private String idNumber;
    private Integer gender;
    private Date birthday;
    private String cardAddress;
    private String cardPositive;
    private String cardReverse;
    private Date issueDate;//签发日期
    private Date expiryDate;//失效日期
    private Date createTime;
}
