package com.cn.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @author Dark
 * @date 2020-07-12 14:12
 */
@Service
public class PaymentService {
    /**
     * 正常访问OK
     * @param id
     * @return
     */
    public String paymentInfo_OK(Integer id){
        return "线程：  "+Thread.currentThread().getName()+"   paymentInfo_OK,id:    "+id+"\t"+"O(∩_∩)O哈哈~";
    }

    /**
     * 超时产生服务降级
     * @param id
     * @return
     */
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeoutHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "5000")  //3秒钟以内就是正常的业务逻辑
    })
    public String paymentInfo_Timeout(Integer id){
        int timeNum = 3;
        //int age = 10/0;
        try {
            TimeUnit.SECONDS.sleep(timeNum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程：  "+Thread.currentThread().getName()+"   paymentInfo_Timeout,id:    "+id+"\t"+"O(∩_∩)O哈哈~ "+"  耗时(秒)："+timeNum;
//        return "线程：  "+Thread.currentThread().getName()+"   paymentInfo_Timeout,id:    "+id+"\t"+"O(∩_∩)O哈哈~ ";
    }

    //兜底方法
    public String paymentInfo_TimeoutHandler(Integer id){
        return "线程：  "+Thread.currentThread().getName()+"    系统繁忙, 请稍候再试 ,id:    "+id+"\t"+"o(╥﹏╥)o";
    }

    //服务熔断
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),  //是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),   //请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),  //时间范围
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"), //失败率达到多少后跳闸
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        if (id < 0){
            throw new RuntimeException("*****id 不能负数");
        }
        String serialNumber = IdUtil.simpleUUID();

        return Thread.currentThread().getName()+"\t"+"调用成功,流水号："+serialNumber;
    }
    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id){
        return "id 不能负数，请稍候再试,(┬＿┬)/~~     id: " +id;
    }
}
