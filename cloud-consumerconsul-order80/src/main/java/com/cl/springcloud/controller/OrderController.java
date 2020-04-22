package com.cl.springcloud.controller;

import com.cl.springcloud.lb.MyloadBalancer;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

/**
 * @Author l
 * @Date 2020/4/17 22:57
 */
@RestController
public class OrderController {

    @Resource(name = "restTemplate1")
    RestTemplate restTemplate1;
    @Resource(name = "restTemplate2")
    RestTemplate restTemplate2;

    @RequestMapping("/getpaymentport")
    public String getPaymentPort(){
        return restTemplate1.getForObject("http://cloud-provider-payment/getport", String.class);
    }

    @RequestMapping("/getpaymentport2")
    public String getPaymentPort2(){
        return restTemplate2.getForObject("http://localhost:8006/getport", String.class);
    }

    @RequestMapping("/test")
    public String test(){
        return "test";
    }

    //-------------------完全自定义负载均衡---------------------
    @Resource
    private MyloadBalancer myloadBalancer;

    @Resource
    private DiscoveryClient discoveryClient;

    @RequestMapping("/getpaymentport3")
    public String getPaymentLB(){
        List<ServiceInstance> instances = discoveryClient.getInstances("cloud-provider-payment"); //获取某服务的各个分部的情况
        ServiceInstance intances = myloadBalancer.intances(instances); //使用自定义的负载均衡器选出一个分部

//        List<String> services = discoveryClient.getServices();
//        for(String service: services){
//            System.out.println(service);
//        }

        URI uri = intances.getUri();
        System.out.println("当前url："+uri);
        return restTemplate2.getForObject(uri+"/getport",String.class);
    }

}
