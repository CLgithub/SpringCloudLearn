package com.cl.myrule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 自定义负载均衡规则
 * @Author l
 * @Date 2020/4/21 09:37
 */
public class MyLoadBalancerRule extends AbstractLoadBalancerRule {

    Logger logger= LoggerFactory.getLogger(this.getClass());

    private AtomicInteger nextServerCyclicCounter;

    public MyLoadBalancerRule() {
        this.nextServerCyclicCounter= new AtomicInteger(0);
    }


    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {

    }

    @Override
    public Server choose(Object key) {
        return this.myChoose(this.getLoadBalancer(), key);
    }

    public Server myChoose(ILoadBalancer lb, Object key) {
        if (lb == null) {
            return null;
        } else {
            Server server = null;
            int count = 0;

            while(true) {
                if (server == null && count++ < 10) {
                    List<Server> reachableServers = lb.getReachableServers();
                    List<Server> allServers = lb.getAllServers();
                    int upCount = reachableServers.size();
                    int serverCount = allServers.size();
                    if (upCount != 0 && serverCount != 0) {
                        int nextServerIndex = this.incrementAndGetModulo(serverCount);
                        server = allServers.get(nextServerIndex);
                        if (server == null) {
                            Thread.yield();
                        } else {
                            if (server.isAlive() && server.isReadyToServe()) {
                                return server;
                            }

                            server = null;
                        }
                        continue;
                    }

                    return null;
                }
                if (count >= 10) {
                }
                return server;
            }
        }
    }

    private int incrementAndGetModulo(int modulo) {
        int current;
        int next;
        do {
            current = this.nextServerCyclicCounter.get();
            next = (current + 1) % modulo;
        } while(!this.nextServerCyclicCounter.compareAndSet(current, next));
        logger.info("得到："+next);
        return next;
    }
}
