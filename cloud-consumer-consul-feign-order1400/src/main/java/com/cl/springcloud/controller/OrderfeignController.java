package com.cl.springcloud.controller;

import com.cl.springcloud.entities.Payment;
import com.cl.springcloud.service.PaymentFeignService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.websocket.server.PathParam;

/**
 * @Author l
 * @Date 2020/5/13 16:06
 */
@RestController
public class OrderfeignController {

    @Resource
    private PaymentFeignService paymentFeignService;

    @RequestMapping("/getport")
    public String getPort(){
        return paymentFeignService.getPort();
    }

    @RequestMapping("/timoutTest/{ms}")
    public String tot(@PathVariable("ms")int ms){
        return paymentFeignService.timoutTest(ms);
    }
}
