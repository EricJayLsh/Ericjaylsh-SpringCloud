package com.ericjaylsh.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Classname ApplicationConfig
 * @Description
 * @Date 2020/9/2 14:13
 * @Created by EricJayLsh
 */
@Configuration
public class ApplicationConfig {

    // 开启负载均衡 （默认是轮询）
    @LoadBalanced   // 当使用自定义的算法时去除该注解(二选一)
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
