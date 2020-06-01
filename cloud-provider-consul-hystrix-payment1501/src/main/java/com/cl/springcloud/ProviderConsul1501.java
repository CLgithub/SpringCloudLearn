package com.cl.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author l
 * @Date 2020/5/20 10:50
 */
@SpringBootApplication
@EnableCircuitBreaker   // 启用服务降级功能
public class ProviderConsul1501 {
    public static void main(String[] args) {
        SpringApplication.run(ProviderConsul1501.class, args);
    }
}
