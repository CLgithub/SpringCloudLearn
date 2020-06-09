package com.cl.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.concurrent.TimeUnit;

/**
 * @Author l
 * @Date 2020/5/20 11:02
 */
@RestController
@DefaultProperties(defaultFallback = "c1_defaultFallback") //配置该类的默认全局熔断defaultFallback方法
public class C1 {

    @Value("${server.port}")
    private String serverPort;

    /**
     * 异常，使用全局默认异常处理
     * @return
     */
    @RequestMapping("/getPort1")
    @HystrixCommand //不指定，使用全局默认
    public String getPort1(){
        int age=10/0;
        return "被调用端--1:"+serverPort +"，线程:"+ Thread.currentThread().getName();
    }

    /**
     * 超时，使用全局默认异常处理
     * @return
     */
    @RequestMapping("/getPort2")
    @HystrixCommand //不指定，使用全局默认
    public String getPort2(){
        try { TimeUnit.SECONDS.sleep(3); } catch (InterruptedException e) { e.printStackTrace(); }
        return "被调用端--2:"+serverPort +"，线程:"+ Thread.currentThread().getName();
    }

    /**
     * 超时，指定异常处理
     * 服务熔断，在服务降级的基础上，添加降级条件和恢复条件
     * @return
     */
    @RequestMapping("/getPort3/{id}")
    @HystrixCommand(
            fallbackMethod = "getPort3_fallbackMethod",
            commandProperties = {
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "100"),
                    @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),    //启用熔断功能
                    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),    // 检查的请求次数阈值
                    @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),    // 时间窗口
                    @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"),    // 失败率达到多少后熔断掉
            }
    ) //若该方法故障，用哪个方法catch
    public String getPort3(@PathVariable("id") Integer id){
        if(id<0){
            throw new RuntimeException("不能为负数");
        }

        return "被调用端--3:"+serverPort + "，线程:" + Thread.currentThread().getName()+", id:"+id;
    }

    public String getPort3_fallbackMethod(@PathVariable("id") Integer id){
        return "被调用端--3_fallbackMethod:"+serverPort+"，线程:"+Thread.currentThread().getName();
    }




    public String c1_defaultFallback(){
        return "被调用端-全局fallack";
    }


    /**
     * 正常访问，用于网关测试
     * @return
     */
    @RequestMapping("/getPort4")
    public String getPort4() {
         return serverPort;
    }
}
