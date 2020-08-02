package com.cn.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Dark
 * @date 2020-08-01 8:33
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentMain9004
{
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain9004.class, args);
    }
}
