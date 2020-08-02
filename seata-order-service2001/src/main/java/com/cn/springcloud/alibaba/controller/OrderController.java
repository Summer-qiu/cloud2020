package com.cn.springcloud.alibaba.controller;

import com.cn.springcloud.alibaba.domain.CommonResult;
import com.cn.springcloud.alibaba.domain.Order;
import com.cn.springcloud.alibaba.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Dark
 * @date 2020-08-02 14:42
 */
@RestController
public class OrderController{
    @Resource
    private OrderService orderServiceImpl;

    @GetMapping("/order/create")
    public CommonResult create(Order order) {
        orderServiceImpl.create(order);
        return new CommonResult(200,"订单创建成功");
    }
}
