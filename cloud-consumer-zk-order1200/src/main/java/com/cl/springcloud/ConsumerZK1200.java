package com.cl.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author l
 * @Date 2020/4/17 17:03
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConsumerZK1200 {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerZK1200.class, args);
    }
}
