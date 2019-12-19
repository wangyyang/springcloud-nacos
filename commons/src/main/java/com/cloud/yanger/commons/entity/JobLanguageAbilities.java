package com.cloud.yanger.commons.entity;

import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

@Data
public class JobLanguageAbilities {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer jobId;
    private Integer languageId;
    private String languageName;
    @TableField(updateStrategy = FieldStrategy.IGNORED)
    private Integer abilityGradeId;
    @TableField(updateStrategy = FieldStrategy.IGNORED)
    private String abilityGradeName;
    private String remark;
    private Date createTime;
}
