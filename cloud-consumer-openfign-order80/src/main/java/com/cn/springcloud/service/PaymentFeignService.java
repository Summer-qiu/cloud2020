package com.cn.springcloud.service;

import com.cn.springcloud.entities.CommonResult;
import com.cn.springcloud.entities.Payment;
import feign.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author Dark
 * @date 2020-07-11 14:26
 */
@Component
@FeignClient("CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {
    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") long id);

    @GetMapping("/payment/feign/timeout")
    public String paymentFeignTimout();
}
