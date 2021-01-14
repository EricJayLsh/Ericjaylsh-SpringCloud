package com.ericjaylsh.springcloud.controller;

import com.ericjaylsh.springcloud.domain.CommonResult;
import com.ericjaylsh.springcloud.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @Classname TemplateController
 * @Description
 * @Date 2020/9/4 22:47
 * @Created by EricJayLsh
 */
@RestController
@RequestMapping("/account")
@Slf4j
public class AccountController {

    @Resource
    private AccountService accountService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "/get")
    public String getId() {
        return "端口： " + serverPort;
    }


    @PostMapping("/decrease")
    public CommonResult decrease(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money) {
        return accountService.decrease(userId, money);
    }

    @GetMapping(value = "/test")
    public CommonResult test( ) {
        return accountService.selectAll();
    }


}
