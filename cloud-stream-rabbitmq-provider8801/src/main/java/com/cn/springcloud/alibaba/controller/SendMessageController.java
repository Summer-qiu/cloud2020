package com.cn.springcloud.alibaba.controller;

import com.cn.springcloud.alibaba.service.IMessageProviderService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Dark
 * @date 2020-07-23 10:53
 */
@RestController
public class SendMessageController {
    @Resource
    private IMessageProviderService iMessageProviderServiceImpl;

    @RequestMapping("/sendMessage")
    public String sendMessage(){
        return iMessageProviderServiceImpl.send();
    }
}
