package com.ericjaylsh.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Classname Payment
 * @Description
 * @Date 2020/9/2 10:30
 * @Created by EricJayLsh
 */
@EnableEurekaClient
@SpringBootApplication
public class SpringCloudConfigClient5102Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudConfigClient5102Application.class, args);
    }
}
