package com.cn.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.AbstractList;
import java.util.ArrayList;

/**
 * 自定义负载均衡所选择的算法策略
 * @author Dark
 * @date 2020-07-10 15:00
 */
@Configuration
public class MySelfRule {
    @Bean
    public IRule myRule(){
        return new RandomRule();    //自定义为随机
    }
}
