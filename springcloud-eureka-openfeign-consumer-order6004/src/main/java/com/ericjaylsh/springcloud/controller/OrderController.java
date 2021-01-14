package com.ericjaylsh.springcloud.controller;

import com.ericjaylsh.springcloud.domain.CommonResult;
import com.ericjaylsh.springcloud.domain.Payment;
import com.ericjaylsh.springcloud.openfeign.IProviderPaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
public class OrderController {

    @Resource
    IProviderPaymentService providerPaymentService;

    // 测试方便 去除 @RequestBody  注解
    @GetMapping(value = "/create")
    public CommonResult<Payment> create(Payment payment) {
        return providerPaymentService.create(payment);

    }

    @GetMapping(value = "/getPaymentById/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable Long id) {
        return providerPaymentService.getPaymentById(id);
    }


    @GetMapping(value = "/timeOut")
    public String timeOut() {
        return providerPaymentService.timeOut();

    }


}

