package com.cn.springcloud.service;

import com.cn.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author Dark
 * @date 2020-06-29 11:27
 */
public interface PaymentService {
    public int create(Payment payment);
    public Payment getPaymentById(@Param("id") long id);
}
