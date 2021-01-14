package com.ericjaylsh.springcloud;

import com.ericjaylsh.myrule.CustomerRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @Classname Payment
 * @Description
 * @Date 2020/9/2 10:30
 * @Created by EricJayLsh
 */
// name = "SPRINGCLOUD-PROVIDER-PAYMENT" 调用的微服务名称, 负载均衡策略配置类  configuration = CustomerRule.class
//@RibbonClient(name = "SPRINGCLOUD-PROVIDER-PAYMENT", configuration = CustomerRule.class)
@EnableDiscoveryClient
@EnableEurekaClient
@SpringBootApplication
public class SpringCloudConsumerOrder6001Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudConsumerOrder6001Application.class, args);

    }
}
