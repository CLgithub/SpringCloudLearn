package com.cl.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 1 openFeign
 * 2 服务网关负载均衡测试
 * @Author l
 * @Date 2020/5/13 15:25
 */
@SpringBootApplication
@EnableFeignClients     // 使用该注解启用openFeign
public class ConsumerConsulFeign1400 {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerConsulFeign1400.class, args);
    }
}
