package com.ericjaylsh.springcloud.controller;

import com.ericjaylsh.springcloud.service.PaymentServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Classname PaymentController
 * @Description
 * @Date 2020/9/2 11:35
 * @Created by EricJayLsh
 */
@RestController
@RequestMapping(value = "/provider")
@Slf4j
public class PaymentController {


    @Resource
    PaymentServiceImpl paymentService;

    @Value("${server.port}")
    private String serverPort;


    @GetMapping(value = "/ok")
    public String testOk() {
        return paymentService.testOk(serverPort);
    }


    @GetMapping(value = "/error")
    public String timeOut() {
        return paymentService.timeOut(serverPort);

    }

    @GetMapping(value = "/breaker/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id) {
        return paymentService.paymentCircuitBreaker(id);

    }


}
