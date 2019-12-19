package com.cloud.yanger.commons.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class SystemAreas {
    @TableId(type = IdType.AUTO)
    private int id;
    private String code;
    private String parentCode;
    private String name;
    private String province;
    private String city;
    private String district;
    private String fullName;
    private Integer grade;
}
