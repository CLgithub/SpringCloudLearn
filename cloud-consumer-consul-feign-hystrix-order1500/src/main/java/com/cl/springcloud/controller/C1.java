package com.cl.springcloud.controller;

import com.cl.springcloud.service.Service15;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.websocket.server.PathParam;
import java.util.concurrent.TimeUnit;

/**
 * @Author l
 * @Date 2020/5/21 17:13
 */
@RestController

public class C1 {

    @Resource
    private Service15 service15;

    @RequestMapping("/getPort1")
    public String getPort1(){
        return service15.getPort1();
    }

    @RequestMapping("/getPort2")
    public String getPort2(){
        return service15.getPort2();
    }

    @RequestMapping("/getPort3/{id}")
    public String getPort3(@PathVariable("id") Integer id){
        return service15.getPort3(id);
    }









}
