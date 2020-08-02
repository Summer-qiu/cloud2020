package com.cn.springcloud.alibaba.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Dark
 * @date 2020-07-10 16:15
 */
@Component
public class MyLB implements LoadBalancer {

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    public final int getAndIncrement(){
        int current;
        int next;
        do {
            current = atomicInteger.get();
            next = current >= 2147483647 ? 0 : current + 1;
            //判断当前值下标是否改变，如开始是0，结束还是0
        } while(!this.atomicInteger.compareAndSet(current, next));   //第一个参数是期望值，第二个参数是修改值是
        System.out.println("*****第几次访问，次数next:"+next);
        return next;
    }

    //负载均衡算法: rest接口第几次请求数%服务器集群总数量=实际调用服务器位置下标, 每次服务重启动后rest接口计数从1开始。
    @Override
    public ServiceInstance instances(List<ServiceInstance> list) {  //得到机器的列表
        int index = getAndIncrement() % list.size();    //得到服务器的下标位置
        return list.get(index);
    }
}
