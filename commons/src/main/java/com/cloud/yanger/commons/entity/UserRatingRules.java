package com.cloud.yanger.commons.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class UserRatingRules {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String gradeName;
    private Integer range_min;
    private Integer range_max;
    private Integer status;
    private Integer type;
}
