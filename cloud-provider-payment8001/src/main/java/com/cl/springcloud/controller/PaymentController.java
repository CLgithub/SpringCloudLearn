package com.cl.springcloud.controller;

import com.cl.springcloud.entities.CommonResult;
import com.cl.springcloud.entities.Payment;
import com.cl.springcloud.service.PaymentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

/**
 * @Author l
 * @Date 2020/4/13 23:35
 */
@RestController
public class PaymentController {

    Logger logger= LoggerFactory.getLogger(this.getClass());

    @Resource
    private PaymentService paymentService;

    //discoveryClient 发现客户端，用于发现微服务系统中目前有哪些服务及其相关信息
    @Resource
    DiscoveryClient discoveryClient;

    @PostMapping(value = "/payment/create")     //应该用put更合理
    public CommonResult<Integer> create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        logger.info("create接收到数据"+payment);
        if(result > 0){
            return new CommonResult<>(200, "插入数据库成功", result);
        }else {
            return new CommonResult<>(444, "插入数据库失败", null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        Payment payment= paymentService.getPaymentById(id);


        if(payment!=null){
            return new CommonResult<>(200, "查询数据库成功", payment);
        }else {
            return new CommonResult<>(444, "查询数据库失败", null);
        }
    }

    @GetMapping("test")
    public String test(){
        return "test8001";
    }

    @GetMapping("/discovery")
    public Object discovery() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {


        List<String> services = discoveryClient.getServices();
        for(String service:services){
            List<ServiceInstance> instances = discoveryClient.getInstances(service);

            for(ServiceInstance sInstance: instances){
                String host = sInstance.getHost();
                String instanceId = sInstance.getInstanceId();
                Map<String, String> metadata = sInstance.getMetadata();
//                System.out.println(host);
//                System.out.println(metadata);
                System.out.println(instanceId);
            }
        }
        return  discoveryClient;
    }

}
