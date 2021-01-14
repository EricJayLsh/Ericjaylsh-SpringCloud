package com.ericjaylsh.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Classname SpringCloudApplication
 * @Description 启动类
 * @Date 2020/9/4 22:32
 * @Created by EricJayLsh
 */

@EnableDiscoveryClient
@SpringBootApplication
public class SpringCloudApplication8006 {
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudApplication8006.class, args);
    }
}
