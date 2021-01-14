package com.ericjaylsh.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @Classname PaymentServiceImpl
 * @Description
 * @Date 2020/9/2 11:28
 * @Created by EricJayLsh
 */
@Service
public class PaymentServiceImpl {


    public String testOk(String serverPort) {
        return "当前线程名称： " + Thread.currentThread().getName() + "服务端口： " + serverPort + " is ok!";
    }

    /******************************************************************************************************/
    /*******************************************服务降级处理*************************************************/

    @HystrixCommand(fallbackMethod = "timeOutHystrixMethod", commandProperties = {
            // 设置服务降级条件 3000 毫秒(超时或者异常都将调用 fallbackMethod 中的方法)
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    public String timeOut(String serverPort) {
        int tim = 5;
        // int t = 10/0;
        try {
            TimeUnit.SECONDS.sleep(tim);
        } catch (InterruptedException e) {
        }
        return "当前线程名称： " + Thread.currentThread().getName() + "服务 [timeOut] 端口： " + serverPort + " 等待时间(s)：" + tim;
    }


    public String timeOutHystrixMethod(String serverPort) {
        return "当前线程名称： " + Thread.currentThread().getName() + " 服务繁忙稍后再试! [timeOutHystrixMethod] 端口：" + serverPort;
    }

    /******************************************************************************************************/
    /*******************************************服务熔断处理*************************************************/
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"), // 是否开启熔断器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"), // 请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"), // 时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60") // 失败率阈值（熔断器断开）
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id) {
        if (id < 0) {
            throw new RuntimeException("*****id不能负数!");
        }
        String serialNumber = IdUtil.simpleUUID();
        return Thread.currentThread().getName() + "\t" + "调用成功，流水号:" + serialNumber;
    }

    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id) {
        return "id不能负数，请稍后再试，~~(ToT)~~id: " + id;
    }

}