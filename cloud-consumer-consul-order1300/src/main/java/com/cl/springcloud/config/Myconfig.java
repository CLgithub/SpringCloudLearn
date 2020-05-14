package com.cl.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Author l
 * @Date 2020/4/17 23:00
 */
@Configuration
public class Myconfig {

    @LoadBalanced
    @Bean
    public RestTemplate restTemplate1(){
        return new RestTemplate();
    }


//    @LoadBalanced
    @Bean
    public RestTemplate restTemplate2(){
        return new RestTemplate();
    }

}
