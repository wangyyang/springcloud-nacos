package com.cloud.yanger.commons.entity;

import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

@Data
public class ResumeLanguageAbilities {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer rsmId;
    private Integer languageId;
    private String languageName;
    private Integer proficiency;
    @TableField(updateStrategy = FieldStrategy.IGNORED)
    private Integer abilityGradeId;
    @TableField(updateStrategy = FieldStrategy.IGNORED)
    private String abilityGradeName;
    private Date createTime;
    private Date updateTime;
    private String remark;
}
