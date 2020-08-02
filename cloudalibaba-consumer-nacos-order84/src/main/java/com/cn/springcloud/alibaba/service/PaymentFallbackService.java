package com.cn.springcloud.alibaba.service;

import com.cn.springcloud.alibaba.entities.CommonResult;
import com.cn.springcloud.alibaba.entities.Payment;
import org.springframework.stereotype.Component;

/**
 * @author Dark
 * @date 2020-08-01 15:17
 */
@Component
public class PaymentFallbackService implements PaymentService
{
    @Override
    public CommonResult<Payment> paymentSQL(Long id)
    {
        return new CommonResult<>(44444,"服务降级返回,---PaymentFallbackService",new Payment(id,"errorSerial"));
    }
}
