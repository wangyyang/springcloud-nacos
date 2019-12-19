package com.cloud.yanger.commons.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

@Data
public class Chat {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer facUserId;
    private Integer userId;
    private Integer jobId;
    private Integer exchangePhone;
    private Date chatLastTime;
}
