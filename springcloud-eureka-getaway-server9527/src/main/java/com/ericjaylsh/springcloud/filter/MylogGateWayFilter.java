package com.ericjaylsh.springcloud.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @Classname MylogGateWayFilter
 * @Description
 * @Date 2020/9/4 11:11
 * @Created by EricJayLsh
 */
@Component
public class MylogGateWayFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        String userName = exchange.getRequest().getQueryParams().getFirst("name");
        if (userName == null || "".equals(userName)) {
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            return exchange.getResponse().setComplete();
        }
        return chain.filter(exchange);
    }

    // filter 顺序 数字越小 优先级越高
    @Override
    public int getOrder() {
        return 0;
    }
}
