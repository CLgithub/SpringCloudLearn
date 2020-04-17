package com.cl.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author l
 * @Date 2020/4/16 21:16
 *
 * pom.xml 引入zookeeper starter后，
 * application.properties 配置将服务注册到zk
 *
 * zk安装目录/apache-zookeeper-3.6.0-bin/bin 下有zkCli.sh客户端
 *      若是docker中的zk，使用docker exec -ti zk1 /bin/bash 进入容器
 * 执行 ./zkCli.sh 使用zk客户端连接zk服务器，
 *
 * ls /
 * ls /services
 * ls /services/cloud-provider-payment/
 * get /services/cloud-provider-payment/1eaedad9-6f06-4249-a45a-b4b19fbac42d  得到服务相关信息
 *
 * 该节点是临时的
 *
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentMain8004 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8004.class, args);
    }
}
