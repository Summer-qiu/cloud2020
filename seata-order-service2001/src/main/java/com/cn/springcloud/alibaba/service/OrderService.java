package com.cn.springcloud.alibaba.service;

import com.cn.springcloud.alibaba.domain.Order;

/**
 * @author Dark
 * @date 2020-08-02 14:26
 */
public interface OrderService{
    void create(Order order);
}