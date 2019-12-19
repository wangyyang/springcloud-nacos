package com.cloud.yanger.commons.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

@Data
public class MessageReceiving {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer messageId;
    private Integer recipient;
    private Integer status;
    private Integer userType;
    private Date readTime;
}
