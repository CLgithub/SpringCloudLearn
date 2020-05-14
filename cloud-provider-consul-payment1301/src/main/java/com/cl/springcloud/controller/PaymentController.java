package com.cl.springcloud.controller;

import com.cl.springcloud.entities.Payment;
import com.cl.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author l
 * @Date 2020/4/17 22:25
 */
@RestController
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/getport")
    public String getPort() {
        return serverPort;
    }


    @Resource
    PaymentService paymentService;

    @RequestMapping("/getOnePayment")
    public Payment getOnePayment(){
        return paymentService.getOnePayment();
    }
}
