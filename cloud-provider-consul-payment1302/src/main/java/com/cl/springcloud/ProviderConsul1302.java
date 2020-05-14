package com.cl.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author l
 * @Date 2020/4/17 22:24
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ProviderConsul1302 {
    public static void main(String[] args) {
        SpringApplication.run(ProviderConsul1302.class, args);
    }
}
