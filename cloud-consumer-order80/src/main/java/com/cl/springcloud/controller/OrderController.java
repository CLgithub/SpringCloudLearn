package com.cl.springcloud.controller;

import com.cl.springcloud.entities.CommonResult;
import com.cl.springcloud.entities.Payment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import javax.websocket.server.PathParam;

//import lombok.extern.log4j.Log4j;

/**
 * @Author l
 * @Date 2020/4/14 16:59
 */
@RestController
@RequestMapping("/consumer")
public class OrderController {

    Logger logger= LoggerFactory.getLogger(this.getClass());

    //通过restTemplate来调用，restTemplate是httpClient的封装
    @Resource
    RestTemplate restTemplate;

    @GetMapping("/payment/create")
    public CommonResult<Payment> create(Payment payment){
        logger.info(payment.toString());
        CommonResult commonResult = restTemplate.postForObject("http://localhost:8001/payment/create", payment, CommonResult.class);
        return commonResult;
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult<CommonResult> getPayment(@PathVariable("id") Long id){
        CommonResult commonResult= restTemplate.getForObject("http://localhost:8001/payment/get/" + id, CommonResult.class, id);
        return commonResult;
    }

}
