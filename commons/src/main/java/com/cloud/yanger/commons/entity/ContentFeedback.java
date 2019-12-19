package com.cloud.yanger.commons.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

@Data
public class ContentFeedback {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer type;
    private String reason;
    private String content;
    private Integer targetId;
    private Integer userId;
    private Integer sysUserId;
    private Integer disposeResult;
    private String remark;
    private Date disposeTime;
    private Date createTime;
}
