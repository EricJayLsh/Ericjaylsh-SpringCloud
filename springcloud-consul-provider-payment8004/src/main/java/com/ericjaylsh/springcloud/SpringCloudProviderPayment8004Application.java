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
public class SpringCloudProviderPayment8004Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudProviderPayment8004Application.class, args);

    }
}
