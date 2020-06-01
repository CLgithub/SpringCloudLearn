package com.cl.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @Author l
 * @Date 2020/5/20 11:02
 */
@RestController
@DefaultProperties(defaultFallback = "c1_defaultFallback") //配置该类的默认全局defaultFallback方法
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
     * @return
     */
    @RequestMapping("/getPort3")
    @HystrixCommand(
            fallbackMethod = "getPort3_fallbackMethod",
            commandProperties = {
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "100")
            }
    ) //若该方法故障，用哪个方法catch
    public String getPort3(){

        try { TimeUnit.SECONDS.sleep(3); } catch (InterruptedException e) { e.printStackTrace(); }
        return "被调用端--3:"+serverPort + "，线程:" + Thread.currentThread().getName();
    }

    public String getPort3_fallbackMethod(){
        return "被调用端--3_fallbackMethod:"+serverPort+"，线程:"+Thread.currentThread().getName();
    }




    public String c1_defaultFallback(){
        return "被调用端-全局fallack";
    }

}
