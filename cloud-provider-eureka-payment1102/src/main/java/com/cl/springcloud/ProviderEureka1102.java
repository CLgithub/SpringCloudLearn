package com.cl.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author l
 * @Date 2020/4/13 22:41
 *
 * 付款微服务8002
 */
@SpringBootApplication
//@EnableEurekaClient
public class ProviderEureka1102 {
    public static void main(String[] args) {
        SpringApplication.run(ProviderEureka1102.class, args);
    }
}
