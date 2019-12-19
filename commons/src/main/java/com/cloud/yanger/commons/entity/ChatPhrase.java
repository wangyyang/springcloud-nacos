package com.cloud.yanger.commons.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

@Data
public class ChatPhrase {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer userType;
    private String content;
    private Date createTime;
}
