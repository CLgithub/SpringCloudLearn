package com.cl.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.websocket.server.PathParam;

/**
 * @Author l
 * @Date 2020/5/21 17:09
 */
@Component
@FeignClient(value = "cloud-provider-consul-hystrix-payment", fallback = Service15Impl.class) // 使用Feign进行服务调用，并指定fallback实现类
public interface Service15 {

    @RequestMapping("/getPort1")
    String getPort1();

    @RequestMapping("/getPort2")
    String getPort2();

    @RequestMapping("/getPort3/{id}")
    String getPort3(@PathVariable("id") Integer id);

    @RequestMapping("/getPort4")
    String getPort4();
}
