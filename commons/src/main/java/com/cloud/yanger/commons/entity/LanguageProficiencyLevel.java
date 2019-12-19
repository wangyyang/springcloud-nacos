package com.cloud.yanger.commons.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class LanguageProficiencyLevel {
    @TableId(type = IdType.AUTO)
    private int id;
    private Integer languageId;
    private String name;
    private Integer sort;
    private Integer status;
}
