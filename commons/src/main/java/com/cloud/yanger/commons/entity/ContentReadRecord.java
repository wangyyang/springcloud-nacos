package com.cloud.yanger.commons.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class ContentReadRecord {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer type;
    private Integer targetId;
    private Integer userId;
    private Integer userType;
    private Data createTime;
}
