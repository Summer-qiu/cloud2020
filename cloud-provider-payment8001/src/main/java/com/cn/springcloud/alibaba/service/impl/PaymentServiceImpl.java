package com.cn.springcloud.alibaba.service.impl;

import com.cn.springcloud.alibaba.entities.Payment;
import com.cn.springcloud.alibaba.dao.PaymentDao;
import com.cn.springcloud.alibaba.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Dark
 * @date 2020-06-29 11:33
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;
    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(long id) {
        return paymentDao.getPaymentById(id);
    }
}
