package com.ericjaylsh.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Classname TemplateController
 * @Description
 * @Date 2020/9/4 22:47
 * @Created by EricJayLsh
 */
@RestController
@RequestMapping("/consumer")
@RefreshScope  // 动态刷新
@Slf4j
public class TemplateController {

    @Autowired
    RestTemplate restTemplate;

    @Value("${server.port}")
    private String serverPort;

    @Value("${nacos.provider-server.name}")
    private String serverName;


    @Value("${config.info}")
    private String configInfo;

    @GetMapping(value = "/get/{id}")
    public String getId(@PathVariable(value = "id") Long id) {
        return restTemplate.getForObject(serverName + "/provider/get/" + id, String.class) + "端口： " + serverPort;
    }

    @GetMapping(value = "/getConfigInfo")
    public String getConfigInfo() {
        return configInfo;
    }


}
