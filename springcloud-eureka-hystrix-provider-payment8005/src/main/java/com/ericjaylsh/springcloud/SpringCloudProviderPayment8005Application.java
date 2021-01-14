package com.ericjaylsh.springcloud;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;

/**
 * @Classname Payment
 * @Description
 * @Date 2020/9/2 10:30
 * @Created by EricJayLsh
 */

// 从Spring Cloud Edgware开始，@EnableEurekaClient 或 @EnableDiscoveryClient 是可省略的。只需加上相关依赖，并进行相应配置，即可将微服务注册到服务发现组件上
@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker      // 启用熔断器
@EnableHystrixDashboard    // 开启界面化监控
public class SpringCloudProviderPayment8005Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudProviderPayment8005Application.class, args);
    }

    /*
    需要被 hystrix 仪表盘监控 必须添加一下配置
          此配置是为了服务监控而配置，与服务容错本身无关，springcloud升级后的坑
          servletRegistrationBean因为springboot的默认路径不是 "/bystrix.stream",
          只要在自己的项目里配置上下面的servlet就可以了
      */
    @Bean
    public ServletRegistrationBean getServlet() {
        HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet);
        registrationBean.setLoadOnStartup(1);
        registrationBean.addUrlMappings("/hystrix.stream");
        registrationBean.setName("HystrixMetricsStreamServlet");
        return registrationBean;
    }
}
