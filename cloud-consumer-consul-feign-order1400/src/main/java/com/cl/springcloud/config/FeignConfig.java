package com.cl.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author l
 * @Date 2020/5/19 15:43
 * openFeign 配置bean
 */
@Configuration
public class FeignConfig {

    // 设置openfeign日志级别
    @Bean
    Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }
}
