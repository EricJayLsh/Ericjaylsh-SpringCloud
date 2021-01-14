package com.ericjaylsh.springcloud.controller;

import com.ericjaylsh.springcloud.domain.CommonResult;
import com.ericjaylsh.springcloud.domain.Payment;
import com.ericjaylsh.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

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
    PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;


    @PostMapping(value = "/create")
    public CommonResult<Payment> create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("插入数据：" + result);
        if (result > 0) {
            return new CommonResult(200, "数据插入成功! serverPort:" + serverPort, result);
        } else {
            return new CommonResult(444, "数据插入失败!", result);
        }
    }

    @GetMapping(value = "/getPaymentById/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("查询数据：" + payment);
        if (payment != null) {
            return new CommonResult(200, "数据查询成功! serverPort:" + serverPort, payment);
        } else {
            return new CommonResult(444, "数据查询失败!不存在该数据...", null);
        }
    }

    @GetMapping(value = "/timeOut")
    public String timeOut() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
        }
        return serverPort;

    }

    @GetMapping(value = "/getT1/{id}")
    public String getT1(@PathVariable Long id) {
        return "gateway测试 path=/provider/getT1/** 端口：" + serverPort + " ID: " + id;

    }

    @GetMapping(value = "/getT2/{id}")
    public String getT2(@PathVariable Long id, HttpServletRequest request) {
        String parameter = request.getParameter("red");
        String header = request.getHeader("X-Request-Red");
        //获取一个参数
        System.out.println("AddRequestParameter=red, blue  " + parameter);
        //获取所有参数
        Map map = request.getParameterMap();
        System.out.println(map);
        System.out.println("- AddRequestHeader=X-Request-Red, blue " + header);

        return "gateway测试 path=/provider/getT2/** 端口：" + serverPort + " ID: " + id + "  AddRequestParameter=red, blue: " + parameter + "X-Request-Red: " + header;

    }


}
