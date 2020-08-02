package com.cn.springcloud.alibaba.service;

import com.cn.springcloud.alibaba.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author Dark
 * @date 2020-06-29 11:27
 */
public interface PaymentService {
    public int create(Payment payment);
    public Payment getPaymentById(@Param("id") long id);
}
