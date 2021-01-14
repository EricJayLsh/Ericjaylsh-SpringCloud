package com.ericjaylsh.springcloud.controller;

import com.ericjaylsh.springcloud.customer.ICustomerRoundRobinRule;
import com.ericjaylsh.springcloud.domain.CommonResult;
import com.ericjaylsh.springcloud.domain.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Classname PaymentController
 * @Description
 * @Date 2020/9/2 11:35
 * @Created by EricJayLsh
 */
@RestController
@RequestMapping(value = "/consumer")
@Slf4j
public class OrderController {

//    此处通过 RestTemplate 调用springcloud-provider-payment8001 服务

    //    public final String PAYMENT_URL = "http://ericjaylsh.dev.xyz:8001";
    public final String PAYMENT_URL = "http://SPRINGCLOUD-PROVIDER-PAYMENT";





    @Resource
    RestTemplate restTemplate;

    @Resource
    DiscoveryClient discoveryClient;
    @Resource
    ICustomerRoundRobinRule customerRoundRobinRule;

    private String applicationServerName = "springcloud-provider-payment";

    // 测试方便 去除 @RequestBody  注解
    @GetMapping(value = "/create")
    public CommonResult<Payment> create(Payment payment) {
        return restTemplate.postForObject(PAYMENT_URL + "/provider/create", payment, CommonResult.class);

    }

    @GetMapping(value = "/create2")
    public CommonResult create2(Payment payment) {
        ResponseEntity responseEntity = restTemplate.postForEntity(PAYMENT_URL + "/provider/create", payment, CommonResult.class);
        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            return new CommonResult(200, "success", responseEntity);
        } else {
            return new CommonResult(444, "");
        }
    }

    @GetMapping(value = "/getPaymentById/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable Long id) {
        return restTemplate.getForObject(PAYMENT_URL + "/provider/getPaymentById/" + id, CommonResult.class);

    }


    @GetMapping(value = "/getPaymentById2/{id}")
    public CommonResult getPaymentById2(@PathVariable Long id) {
        // getForEntity 返回值更加多样
        ResponseEntity responseEntity = restTemplate.getForEntity(PAYMENT_URL + "/provider/getPaymentById/" + id, CommonResult.class);

        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            return new CommonResult(200, "success", responseEntity);
        } else {
            return new CommonResult(444, "");
        }
    }


    // 自定义 ribbon 负载均衡轮循算法
    @GetMapping(value = "/customerRibbon/{id}")
    public CommonResult customerRibbon(@PathVariable Long id) {
        return restTemplate.getForObject(customerRoundRobinRule.getCustomerRoundRobinRule(applicationServerName).getUri() + "/provider/getPaymentById/" + id, CommonResult.class);
    }


    @GetMapping(value = "/getPaymentServerInfo")
    public DiscoveryClient getPaymentServerInfo() {
        List<String> services = discoveryClient.getServices();
        for (String element : services) {
            System.out.println("*****element: " + element);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("SPRINGCLOUD-PROVIDER-PAYMENT");
        for (ServiceInstance instance : instances) {
            System.out.println(instance.getServiceId() + "\t" + instance.getHost() + "\t" + instance.getPort() + "\t" + instance.getUri());
        }
        return this.discoveryClient;
    }
}

