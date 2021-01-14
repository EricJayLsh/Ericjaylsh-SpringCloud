package com.ericjaylsh.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname PaymentController
 * @Description
 * @Date 2020/9/2 11:35
 * @Created by EricJayLsh
 */
@RestController
@RequestMapping(value = "/test")
public class PaymentController {

    @Value("${server.port}")
    private String configInfo;

    @GetMapping(value = "/get")
    public String getConfigInfo() {
        return "bootstrap.yml 设置端口" + configInfo;

    }


}
