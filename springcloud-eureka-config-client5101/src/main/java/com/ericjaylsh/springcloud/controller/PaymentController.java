package com.ericjaylsh.springcloud.controller;

import com.sun.xml.internal.bind.v2.TODO;
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

    @Value("${ericjaylsh.info}")
    private String configInfo;

    @GetMapping(value = "/getConfigInfo")
    public String getConfigInfo() {
        // TODO :这里有个问题 添加配置中心uri之后 当前服务端口失效 直接变成9000 该问题待解决
        return "config client 获取到的配置信息：" + configInfo;

    }


}
