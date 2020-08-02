package com.cn.springcloud.alibaba.controller;

import com.cn.springcloud.alibaba.service.PaymentFeignService;
import com.cn.springcloud.alibaba.entities.CommonResult;
import com.cn.springcloud.alibaba.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 使用openfeign 替代了RestTemplate+Ribbon
 * @author Dark
 * @date 2020-07-11 14:38
 */
@RestController
@Slf4j
public class OrderFeignController {

    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") long id){
        return paymentFeignService.getPaymentById(id);
    }

    @GetMapping("/consumer/payment/feign/timeout")
    public String paymentFeignTimout(){
        //openFeign+Ribbon客户端一般默认等待1秒钟
        return paymentFeignService.paymentFeignTimout();
    }
}
