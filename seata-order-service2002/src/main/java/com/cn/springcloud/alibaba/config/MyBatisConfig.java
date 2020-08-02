package com.cn.springcloud.alibaba.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Dark
 * @date 2020-08-02 15:40
 */
@Configuration
@MapperScan({"com.cn.springcloud.alibaba.dao"})
public class MyBatisConfig {

}