package com.cl.springcloud;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

/**
 * 1 服务降级、熔断
 * @Author l
 * @Date 2020/5/20 17:32
 */
@SpringBootApplication
@EnableFeignClients     // 使用该注解启用openFeign
@EnableHystrix          // 启用Hystrix，服务降级
public class ConsumerConsulFeignHystrix1500 {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerConsulFeignHystrix1500.class, args);
    }


}
