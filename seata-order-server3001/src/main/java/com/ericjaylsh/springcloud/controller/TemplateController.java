package com.ericjaylsh.springcloud.controller;

import com.ericjaylsh.springcloud.domain.CommonResult;
import com.ericjaylsh.springcloud.domain.Order;
import com.ericjaylsh.springcloud.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
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
@RequestMapping("/order")
@Slf4j
public class TemplateController {


    @Resource
    private OrderService orderService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "/get")
    public String getId() {
        return "端口： " + serverPort;
    }

    @GetMapping(value = "/test")
    public CommonResult test() {
        return orderService.selectAll();
    }


    @GetMapping(value = "/create")
    public CommonResult getId(Order order) {
        orderService.create(order);
        return new CommonResult(200,"订单创建成功！");
    }


}
