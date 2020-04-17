package com.cl.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @Author l
 * @Date 2020/4/17 17:06
 */
@RestController
public class OrderZKController {

    @Resource
    RestTemplate restTemplate;

    @RequestMapping("/payment/zk")
    public String paymentzk(){
        return restTemplate.getForObject("http://cloud-provider-payment/payment/zk", String.class);
//        return restTemplate.getForObject("http://CLOUD-PROVIDER-PAYMENT/payment/zk", String.class);
    }
}
