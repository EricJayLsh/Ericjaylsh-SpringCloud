package com.ericjaylsh.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Classname GatewayConfig
 * @Description
 * @Date 2020/9/4 9:10
 * @Created by EricJayLsh
 */
@Configuration
public class GatewayConfig {

    // 添加路由配置
    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("route1", r -> r.path("/guonei").uri("http://news.baidu.com"))
                .route("route2", r -> r.path("/guoji").uri("http://news.baidu.com"))
                .route("route3", r -> r.path("/mil").uri("http://news.baidu.com"))
                .build();
    }
}
