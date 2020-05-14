package com.cl.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author l
 * @Date 2020/4/13 22:41
 *
 * 付款微服务8001
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class ProviderEureka1101 {
    public static void main(String[] args) {
        SpringApplication.run(ProviderEureka1101.class, args);
    }
}
