package com.cloud.yanger.commons.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class FacilitatorStaff {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer facId;
    private Integer userId;
    private Integer status;
    private String position;
    private String remark;
}
