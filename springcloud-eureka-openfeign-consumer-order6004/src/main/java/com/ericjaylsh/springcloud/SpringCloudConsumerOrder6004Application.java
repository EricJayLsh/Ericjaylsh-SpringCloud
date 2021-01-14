package com.ericjaylsh.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Classname Payment
 * @Description
 * @Date 2020/9/2 10:30
 * @Created by EricJayLsh
 */
@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
public class SpringCloudConsumerOrder6004Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudConsumerOrder6004Application.class, args);

    }
}
