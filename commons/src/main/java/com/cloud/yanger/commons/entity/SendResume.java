package com.cloud.yanger.commons.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

@Data
public class SendResume {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer userId;
    private Integer status;
    private String remark;
    private Date createTime;
    private Date lastSendTime;
    private Date lastRecommendTime;
}
