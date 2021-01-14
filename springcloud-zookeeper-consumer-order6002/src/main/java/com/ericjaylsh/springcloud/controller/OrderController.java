package com.ericjaylsh.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Classname PaymentController
 * @Description
 * @Date 2020/9/2 11:35
 * @Created by EricJayLsh
 */
@RestController
@RequestMapping(value = "/zk/consumer")
@Slf4j
public class OrderController {

    private final String PAYMENT_URL = "http://springcloud-provider-payment";

    @Resource
    private RestTemplate restTemplate;


    // 测试方便 去除 @RequestBody  注解
    @GetMapping(value = "/getPort")
    public String getPort() {
        return restTemplate.getForObject(PAYMENT_URL + "/zk/provider/getPort", String.class);
    }

}

