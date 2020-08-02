package com.cn.springcloud.alibaba.service;

import org.springframework.stereotype.Component;

/**
 * 解决Controller代码膨胀和混乱
 * @author Dark
 * @date 2020-07-14 11:04
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "-----PaymentFallbackService fall back-paymentInfo_OK , (┬＿┬)";
    }

    @Override
    public String paymentInfo_Timeout(Integer id) {
        return "-----PaymentFallbackService fall back-paymentInfo_TimeOut , (┬＿┬)";
    }
}
