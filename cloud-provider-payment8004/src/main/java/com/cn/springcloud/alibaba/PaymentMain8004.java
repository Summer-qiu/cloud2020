package com.cn.springcloud.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Dark
 * @date 2020-07-06 10:22
 */
@SpringBootApplication
@EnableDiscoveryClient  //该注解用于使用consul或zookeeper时向注册中心注册服务
public class PaymentMain8004 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8004.class,args);
    }
}
