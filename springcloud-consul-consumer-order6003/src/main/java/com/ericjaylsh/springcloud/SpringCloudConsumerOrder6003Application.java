package com.ericjaylsh.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Classname Payment
 * @Description
 * @Date 2020/9/2 10:30
 * @Created by EricJayLsh
 */
@EnableDiscoveryClient
@SpringBootApplication
public class SpringCloudConsumerOrder6003Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudConsumerOrder6003Application.class, args);
    }
}
