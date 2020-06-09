package com.cl.sprigncloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * 网关路由配置 配置Bean 方式
 *
 * @Author l
 * @Date 2020/6/8 11:39
 */
@Configuration
public class GateWayConfig {

    @Bean
    public RouteLocator routes(RouteLocatorBuilder routeLocatorBuilder){
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
//        routes.route("r2_1501",new PredicateSpec("").uri("http://www.baidu.com")).build();
        RouteLocator r2_1501 = routes.route(
                "r2_1501",
                r -> r.path("/guonei").uri("http://news.baidu.com/guonei")
        ).build();
        return r2_1501;
    }


}
