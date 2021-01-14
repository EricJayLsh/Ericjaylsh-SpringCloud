package com.ericjaylsh.springcloud.controller;

import com.ericjaylsh.springcloud.domain.CommonResult;
import com.ericjaylsh.springcloud.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Classname TemplateController
 * @Description
 * @Date 2020/9/4 22:47
 * @Created by EricJayLsh
 */
@RestController
@RequestMapping("/storage")
@Slf4j
public class StorageController {


    @Resource
    private StorageService storageService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "/get")
    public String getId() {
        return "端口： " + serverPort;
    }


    @PostMapping("/decrease")
    CommonResult decrease(@RequestParam("productId") Long productId, @RequestParam("count") Integer count) {
        return storageService.decrease(productId, count);
    }

    @GetMapping(value = "/test")
    public CommonResult test( ) {
        return storageService.selectAll();
    }

}
