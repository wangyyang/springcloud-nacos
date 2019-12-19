package com.cloud.yanger.commons.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class VisaLibrary {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer worldId;
    private String visaName;
    private String remark;
    private Integer status;
}
