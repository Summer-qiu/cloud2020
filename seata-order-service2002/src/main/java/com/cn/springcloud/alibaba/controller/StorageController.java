package com.cn.springcloud.alibaba.controller;

import com.cn.springcloud.alibaba.domain.CommonResult;
import com.cn.springcloud.alibaba.service.StorageService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Dark
 * @date 2020-08-02 15:27
 */
@RestController
public class StorageController {

    @Resource
    private StorageService storageService;


    //扣减库存
    @RequestMapping("/storage/decrease")
    public CommonResult decrease(Long productId, Integer count) {
        storageService.decrease(productId, count);
        return new CommonResult(200,"扣减库存成功！");
    }
}
