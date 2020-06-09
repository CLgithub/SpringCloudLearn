package com.cl.springcloud;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

/**
 * 1. 服务降级 熔断
 * 2. 仪表盘监控
 * @Author l
 * @Date 2020/5/20 10:50
 */
@SpringBootApplication
@EnableCircuitBreaker   // 启用服务熔断功能
public class ProviderConsul1501 {
    public static void main(String[] args) {
        SpringApplication.run(ProviderConsul1501.class, args);
    }

    /**
     * 此配置是为了服务监控而配置，与服务本身无关，
     * servletRegistationBean因为springboot的默认路径不是"/hystrix.stream"
     * 只能自己配置
     * @return
     */
    @Bean
    public ServletRegistrationBean getServlet(){
        HystrixMetricsStreamServlet hystrixMetricsStreamServlet=new HystrixMetricsStreamServlet();
        ServletRegistrationBean servletRegistrationBean=new ServletRegistrationBean(hystrixMetricsStreamServlet);
        servletRegistrationBean.setLoadOnStartup(1);
        servletRegistrationBean.addUrlMappings("/hystrix.stream");
        servletRegistrationBean.setName("HystrixMetricsStreamServlet");
        return servletRegistrationBean;
    }
}
