package com.cl.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author l
 * @Date 2020/6/12 11:23
 */
@RestController
@RefreshScope       // 动态刷新
public class ConfigClientController {

    @Value("${c1.c2}")  //配置文件中的配置项目
    private String configInfo;

    @RequestMapping("/configInfo")
    public String getConfigInfo(){
        return configInfo;
    }

}
