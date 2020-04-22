package com.cl.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author l
 * @Date 2020/4/21 10:51
 */
@Component
public class MyloadBalancerImp implements MyloadBalancer {

    // 每次的初始 高并发的情况下，i++无法保证原子性，往往会出现问题，所以引入AtomicInteger类
    private AtomicInteger atomicInteger = new AtomicInteger(0);

    public final int getAndIncrement(int modulo){
        int current;
        int index;
        do{
            current = this.atomicInteger.get();
            index = (current + 1) % modulo;
        }while (!this.atomicInteger.compareAndSet(current, index));
        return index;
    }

    @Override
    public ServiceInstance intances(List<ServiceInstance> serviceInstances) {
        int size = serviceInstances.size();
        int index = getAndIncrement(size);
        ServiceInstance serviceInstance = serviceInstances.get(index);
        return serviceInstance;
    }


}
