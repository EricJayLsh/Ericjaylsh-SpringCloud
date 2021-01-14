package com.ericjaylsh.springcloud.eureka.zuulserver9528;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient
public class SpringcloudEurekaZuulServer9528Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudEurekaZuulServer9528Application.class, args);
    }

}
