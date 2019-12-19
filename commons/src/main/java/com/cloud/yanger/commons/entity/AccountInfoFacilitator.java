package com.cloud.yanger.commons.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class AccountInfoFacilitator {
    @TableId(type = IdType.AUTO)
    private int id;
    private Integer facId;
    private Double cashAccount;
    private Double creditAccount;
    private Double frozenAssets;
    private Integer integralAccount;
    private Integer creditIntegral;
    private Integer actVipGrowth;
    private String withdrawalPassword;
}
