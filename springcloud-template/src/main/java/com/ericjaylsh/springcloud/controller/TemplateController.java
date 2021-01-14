package com.ericjaylsh.springcloud.controller;

import com.ericjaylsh.springcloud.service.ITemplateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Classname TemplateController
 * @Description
 * @Date 2020/9/4 22:47
 * @Created by EricJayLsh
 */
@RestController
@RequestMapping("/template")
@Slf4j
public class TemplateController {


    @Resource
    ITemplateService templateService;

    @Value("${server.port}")
    private String serverPort;


    @GetMapping(value = "/get/{id}")
    public String getId(@PathVariable Long id) {
        return "端口： " + serverPort;
    }


}
