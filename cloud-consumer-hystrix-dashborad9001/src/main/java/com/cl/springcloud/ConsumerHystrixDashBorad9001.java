package com.cl.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Hystrix监控
 * @Author l
 * @Date 2020/6/1 16:22
 */
@SpringBootApplication
@EnableFeignClients
@EnableHystrix
@EnableHystrixDashboard  // 启用EnableHystrix仪表盘功能
public class ConsumerHystrixDashBorad9001 {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerHystrixDashBorad9001.class);
    }
}
