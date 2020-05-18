package com.cl.springcloud.service;

import com.cl.springcloud.entities.CommonResult;
import com.cl.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.websocket.server.PathParam;

/**
 * @Author l
 * @Date 2020/5/13 15:38
 */
@Component
//@FeignClient(value = "CLOUD_PROVIDER_CONSUL_PAYMENT")   //要用OpenFeign负载均衡的服务
@FeignClient(value = "cloud-provider-consul-payment")   //要用OpenFeign负载均衡的服务
public interface PaymentFeignService {


    @GetMapping("/getport")  // 具体服务的接口
    String getPort();

    @GetMapping("/timoutTest/{ms}")
    String timoutTest(@PathVariable("ms")int ms);
}
