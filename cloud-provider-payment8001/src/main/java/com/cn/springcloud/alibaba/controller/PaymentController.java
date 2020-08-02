package com.cn.springcloud.alibaba.controller;

import com.cn.springcloud.alibaba.entities.CommonResult;
import com.cn.springcloud.alibaba.entities.Payment;
import com.cn.springcloud.alibaba.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author Dark
 * @date 2020-06-29 11:38
 */
@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentServiceImpl;

    @Value("${server.port}")
    private String serverPort;

    //对于注册进eureka里面的微服务，可以通过服务发现来获得该服务的信息
    @Resource
    private DiscoveryClient discoveryClient;

    //客户端通过GET请求访问该服务，故需要加Requestbody接收传递过来的数据
    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int result = paymentServiceImpl.create(payment);
        log.info("****插入结果："+result);

        if (result>0){
            return new CommonResult(200,"插入数据库成功,serverPort = "+serverPort,result);
        }else {
            return new CommonResult(444,"插入数据库失败",null);
        }
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") long id){
        Payment payment = paymentServiceImpl.getPaymentById(id);
        log.info("****查询结果："+payment);

        if (payment!=null){
            return new CommonResult(200,"查询成功,serverPort = "+serverPort,payment);
        }else {
            return new CommonResult(444,"没有对应记录，查询ID失败："+id,null);
        }
    }

    @GetMapping("/payment/discovery")
    public Object discovery(){
        //服务注册中心的所有服务
        List<String> services = discoveryClient.getServices();
        for (String e : services) {
            log.info("*****element:"+e);
        }
        //一个微服务名称下的全部个体实例
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());

        }
        return this.discoveryClient;
    }

    @GetMapping("/payment/lb")
    public String getPaymentLB(){
        return serverPort;
    }

    //测试Feign超时
    @GetMapping("/payment/feign/timeout")
    public String paymentFeignTimout(){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }

    @GetMapping("/payment/zipkin")
    public String paymentZipkin()
    {
        return "hi ,i'am paymentzipkin server fall back，welcome to atguigu，O(∩_∩)O哈哈~";
    }

}
