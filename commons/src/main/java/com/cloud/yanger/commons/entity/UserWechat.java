package com.cloud.yanger.commons.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

@Data
public class UserWechat {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer userId;
    private String nickname;
    private String openId;
    private String unionId;
    private Date createTime;
}
