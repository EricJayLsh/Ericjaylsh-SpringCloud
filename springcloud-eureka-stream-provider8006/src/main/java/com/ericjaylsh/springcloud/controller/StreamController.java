package com.ericjaylsh.springcloud.controller;

import com.ericjaylsh.springcloud.service.IStreamProviderService;
import org.springframework.web.bind.annotation.GetMapping;
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
@RequestMapping("/stream")
public class StreamController {

    @Resource
    IStreamProviderService streamProviderService;

    @GetMapping(value = "/get")
    public String getId() {
        return streamProviderService.send();
    }

    @GetMapping(value = "/hello")
    public String hello() {
        return "hello";
    }


}
