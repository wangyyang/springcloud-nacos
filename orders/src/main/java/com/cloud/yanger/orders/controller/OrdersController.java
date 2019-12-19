package com.cloud.yanger.orders.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.cloud.yanger.commons.entity.Orders;
import com.cloud.yanger.orders.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("orders")
public class OrdersController {

    @Autowired
    private OrdersService ordersService;


    @PostMapping("getOrderList")
    public Object getOrderList() {
        LambdaQueryWrapper<Orders> lq = new LambdaQueryWrapper<>();
        lq.eq(Orders::getStatus, 0);
        return ordersService.list(lq);
    }
}
