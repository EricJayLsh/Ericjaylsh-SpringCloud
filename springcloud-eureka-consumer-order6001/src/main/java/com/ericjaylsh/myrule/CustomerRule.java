package com.ericjaylsh.myrule;

import com.netflix.loadbalancer.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Classname CustomerRule
 * @Description 自定义一个ribbon 负载均衡算法。注意不能放在 @SpringBootApplication 所在包下
 * @Date 2020/9/3 9:46
 * @Created by EricJayLsh
 */

@Configuration
public class CustomerRule {

    // 默认是轮循

    // 随机
    @Bean
    public IRule myRandomRule() {
        return new RandomRule();
    }

/*
    // 先按照RoundRobinRule的策略获取服务，如果获取服务失败则在指定时间内会进行重
    @Bean
    public IRule myRetryRule() {
        return new RetryRule();
    }


    // 先按照RoundRobinRule的策略获取服务，响应速度快的获得的权重高
    @Bean
    public IRule myWeightedResponseTimeRule() {
        return new WeightedResponseTimeRule();
    }


    // 会先过滤掉由于多次访问故障而处于断路器跳闸状态的服务，然后选择一个并发量最小的服务
    @Bean
    public IRule myBestAvailableRule() {
        return new BestAvailableRule();
    }


    // 先过滤掉故障实例，再选择并发较小的实例
    @Bean
    public IRule myAvailabilityFilteringRule() {
        return new AvailabilityFilteringRule();
    }


    // 默认规则,复合判断server所在区域的性能和server的可用性选择服务器
    @Bean
    public IRule myZoneAvoidanceRule() {
        return new ZoneAvoidanceRule();
    }

    */

}
