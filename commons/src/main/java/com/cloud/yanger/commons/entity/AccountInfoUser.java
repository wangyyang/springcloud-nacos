package com.cloud.yanger.commons.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class AccountInfoUser {
    @TableId(type = IdType.AUTO)
    private int id;
    private Integer userId;
    private Double cashAccount;
    private Double frozenAssets;
    private Integer integralAccount;
    private Integer actVipGrowth;
    private String withdrawalPassword;
}
