package com.cl.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @Author l
 * @Date 2020/4/21 10:48
 */
public interface MyloadBalancer {

   /**
    * 根据某服务的所有分部，获取其中某个分部，内部算法去定各个分部的负载情况
    * @param serviceInstances
    * @return
    */
   ServiceInstance intances(List<ServiceInstance> serviceInstances);

}
