package com.cl.springcloud.service;

import com.cl.springcloud.entities.CommonResult;
import com.cl.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author l
 * @Date 2020/5/13 15:38
 */
@Component
@FeignClient(value = "cloud-provider-consul-payment")   //要用OpenFeign负载均衡的服务
public interface PaymentFeignService {

    @GetMapping("/getport")  // 具体服务的接口
    String getPort();
}
