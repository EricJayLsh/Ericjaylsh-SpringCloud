package com.ericjaylsh.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Classname ApplicationConfig
 * @Description
 * @Date 2020/9/2 14:13
 * @Created by EricJayLsh
 */
@Configuration
public class ApplicationConfig {

    // 配置 feign 的日志级别
    @Bean
    public Logger.Level feignLogger() {
        return Logger.Level.FULL;
    }
}
