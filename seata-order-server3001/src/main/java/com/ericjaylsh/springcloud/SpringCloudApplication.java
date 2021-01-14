package com.ericjaylsh.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Classname SpringCloudApplication
 * @Description 启动类
 *
 *
 *
 *
 * 注意细节 根据官网上来 认真仔细 可以减少30%的错误 还有注意配置文件不起效时 删除重现添加（切记切记 有时候看上去格式是对的 但是实际上不起作用）
 * @Date 2020/9/4 22:32
 * @Created by EricJayLsh
 */

@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class SpringCloudApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudApplication.class, args);
    }
}
