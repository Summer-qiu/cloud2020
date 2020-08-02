package com.cn.springcloud.alibaba.service;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Dark
 * @date 2020-08-02 15:25
 */
public interface StorageService {
    // 扣减库存
    void decrease(@RequestParam("productId") Long productId,@RequestParam("count") Integer count);
}
