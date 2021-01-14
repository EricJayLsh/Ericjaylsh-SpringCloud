package com.ericjaylsh.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class SpringCloudAlibabaApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudAlibabaApplication.class, args);
    }
}
