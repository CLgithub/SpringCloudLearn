package com.cl.sprigncloud.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * 自定义gateWay过滤器
 * @Author l
 * @Date 2020/6/9 15:54
 */
@Component
public class MyLogGateWayFilter implements GlobalFilter, Ordered{

    Logger logger=LoggerFactory.getLogger(MyLogGateWayFilter.class);

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        logger.info("********** 1，进入到过滤器 **********");
        String uname = exchange.getRequest().getQueryParams().getFirst("uname");
        if(uname==null){
            logger.info("非法用户");
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);    //设置响应为不被接受
            Mono<Void> mono = exchange.getResponse().setComplete();
            return mono;
        }
        Mono<Void> mono= chain.filter(exchange);    // 放行给下一个过滤器
        return mono;
    }

    // 过滤器优先级，数字越小，优先级越高
    @Override
    public int getOrder() {
        return 0;
    }

}
