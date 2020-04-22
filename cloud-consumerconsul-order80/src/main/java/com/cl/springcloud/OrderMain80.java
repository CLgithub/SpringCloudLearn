package com.cl.springcloud;

import com.cl.myrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @Author l
 * @Date 2020/4/17 22:55
 */
@SpringBootApplication
@EnableDiscoveryClient
@RibbonClient(name = "cloud-provider-payment", configuration = MySelfRule.class) // 配置哪个服务应用哪种负载均衡方式
public class OrderMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderMain80.class, args);
    }
}
