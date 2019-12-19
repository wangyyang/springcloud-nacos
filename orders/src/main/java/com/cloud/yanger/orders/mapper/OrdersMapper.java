package com.cloud.yanger.orders.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cloud.yanger.commons.entity.Orders;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrdersMapper extends BaseMapper<Orders> {
}
