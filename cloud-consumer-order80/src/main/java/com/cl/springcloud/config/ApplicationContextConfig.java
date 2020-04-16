package com.cl.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Author l
 * @Date 2020/4/15 22:06
 */
@Configuration
public class ApplicationContextConfig {

    @LoadBalanced   //发请求时使用负载均衡机制
    @Bean
    public RestTemplate restTemplate1(){
        return new RestTemplate();
    }


}
