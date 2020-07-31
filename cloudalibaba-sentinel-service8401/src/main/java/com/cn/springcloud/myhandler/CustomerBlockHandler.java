package com.cn.springcloud.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.cn.springcloud.entities.CommonResult;

/**
 * 实现业务和代码解耦
 * 避免代码膨胀
 * @author Dark
 * @date 2020-07-31 15:55
 */
public class CustomerBlockHandler {

    public static CommonResult handlerException(BlockException exception) {
        return new CommonResult(2020, "自定义global限流处理信息....CustomerBlockHandler---1");

    }

    public static CommonResult handlerException2(BlockException exception) {
        return new CommonResult(2020, "自定义global限流处理信息....CustomerBlockHandler---2");

    }
}
