package com.cloud.yanger.orders.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cloud.yanger.commons.entity.Orders;
import com.cloud.yanger.orders.mapper.OrdersMapper;
import com.cloud.yanger.orders.service.OrdersService;
import org.springframework.stereotype.Service;

@Service
public class OrdersServiceImpl extends ServiceImpl<OrdersMapper, Orders> implements OrdersService {
}
