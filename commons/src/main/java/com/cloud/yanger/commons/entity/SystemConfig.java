package com.cloud.yanger.commons.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class SystemConfig {
    @TableId(type = IdType.AUTO)
    private int id;
    private String name;
    private String value;
    private String remark;
    private Integer status;

}
