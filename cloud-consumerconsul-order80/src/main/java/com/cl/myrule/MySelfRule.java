package com.cl.myrule;

import com.netflix.loadbalancer.BestAvailableRule;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 负载均衡规则选择器
 * @Author l
 * @Date 2020/4/20 17:06
 */
@Configuration
public class MySelfRule {

    @Bean
    public IRule myRule(){
//        RandomRule rule = new RandomRule();   // 随机
//        BestAvailableRule rule= new BestAvailableRule();
        MyLoadBalancerRule rule = new MyLoadBalancerRule();
        return rule;
    }
}
