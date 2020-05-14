package com.cl.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author l
 * @Date 2020/4/14 16:57
 *
 * 订单微服务8000
 */
//@EnableEurekaClient
@SpringBootApplication
@EnableDiscoveryClient
public class ConsumerEureka1100 {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerEureka1100.class, args);
    }

}
