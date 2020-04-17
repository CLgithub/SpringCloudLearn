package com.cl.springcloud.controller;

import com.cl.springcloud.entities.CommonResult;
import com.cl.springcloud.entities.Payment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

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
//    @Resource
    @Autowired
    RestTemplate myRestTemplate;


    public final static String URL1="http://cloud-provider-payment";

    @GetMapping("/payment/create")
    public CommonResult create(Payment payment){
        return myRestTemplate.postForObject(URL1+"/payment/create", payment, CommonResult.class);
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult getPayment(@PathVariable("id") Long id){
        System.out.println(URL1+"/payment/get/" + id);
        CommonResult forObject = myRestTemplate.getForObject(URL1 + "/payment/get/" + id, CommonResult.class, id);
        return forObject;
    }

    @GetMapping("test")
    public String test(){
        return myRestTemplate.getForObject(URL1+"/test",String.class);
    }

}
