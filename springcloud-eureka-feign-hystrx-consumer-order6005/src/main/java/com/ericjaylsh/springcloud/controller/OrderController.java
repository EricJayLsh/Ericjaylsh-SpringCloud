package com.ericjaylsh.springcloud.controller;

import com.ericjaylsh.springcloud.openfeign.IProviderPaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Classname PaymentController
 * @Description
 * @Date 2020/9/2 11:35
 * @Created by EricJayLsh
 */
@RestController
@RequestMapping(value = "/consumer")
@Slf4j
// 配置全局 服务降价方法
@DefaultProperties(defaultFallback = "fallbackMethodAll")
public class OrderController {

    @Resource
    IProviderPaymentService providerPaymentService;

    @GetMapping(value = "/ok")
    public String testOk() {
        return providerPaymentService.testOk();
    }

    // 没有 @HystrixCommand 注解 则不对该方法进行服务降级出来 回出现报错信息(没有做服务统一降级出来除外)
    @GetMapping(value = "/error")
    public String timeOut() {
        return providerPaymentService.timeOut();
    }


    @HystrixCommand
    @GetMapping(value = "/error2")
    public String timeOut2() {
        return providerPaymentService.timeOut();
    }

    // 服务调用方 服务降级处理 当调用的方法出错时 ****则直接执行 fallbackMethod 方法****
    @HystrixCommand(fallbackMethod = "timeOutHystrixMethod", commandProperties = {
            // 设置服务降级条件 1500 毫秒(超时或者异常都将调用 fallbackMethod 中的方法)
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")
    })
    @GetMapping(value = "/error3")
    public String timeOut3() {
        return providerPaymentService.timeOut();
    }

    public String timeOutHystrixMethod() {
        return "当前线程名称： " + Thread.currentThread().getName() + " consumer 服务繁忙稍后再试!1500毫秒没有返回结果，我生气了，哼！！！ 端口：6005";
    }

    public String fallbackMethodAll() {
        return " consumer 服务繁忙 稍后再试!";
    }


}

