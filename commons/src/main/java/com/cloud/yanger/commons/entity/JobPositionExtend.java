package com.cloud.yanger.commons.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class JobPositionExtend {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer jobId;
    private Integer positionFirst;
    private String positionFirstName;
    private Integer positionSecond;
    private String positionSecondName;
    private Integer positionThird;
    private String positionThirdName;
}
