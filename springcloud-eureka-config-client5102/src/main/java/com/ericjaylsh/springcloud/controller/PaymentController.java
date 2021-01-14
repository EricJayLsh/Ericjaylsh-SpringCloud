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
@RequestMapping(value = "/client")
@RefreshScope  // 刷新配置中心获取到的配置内容，使得客户端可以动态感知到配置中心的变化
public class PaymentController {

    @Value("${ericjaylsh.mojito}")
    private String configInfo;

    @GetMapping(value = "/getConfigInfo")
    public String getConfigInfo() {
        return "config client 获取到的配置信息：" + configInfo;

    }


}
