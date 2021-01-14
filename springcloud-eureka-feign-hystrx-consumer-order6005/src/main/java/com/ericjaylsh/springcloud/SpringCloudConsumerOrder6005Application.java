package com.ericjaylsh.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Classname Payment
 * @Description
 * @Date 2020/9/2 10:30
 * @Created by EricJayLsh
 */
// 启用 Hystrix 注意在服务提供方不是这个注解，参看8005
@EnableHystrix
@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
public class SpringCloudConsumerOrder6005Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudConsumerOrder6005Application.class, args);

    }
}
