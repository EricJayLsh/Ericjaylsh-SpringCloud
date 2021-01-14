package com.ericjaylsh.springcloud.service.impl;

import com.ericjaylsh.springcloud.domain.CommonResult;
import com.ericjaylsh.springcloud.service.AccountService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @Classname AccountServiceImpl
 * @Description
 * @Date 2020/9/7 19:29
 * @Created by EricJayLsh
 */
@Service
public class AccountServiceImpl implements AccountService {
    @Override
    public CommonResult decrease(Long userId, BigDecimal money) {
        return new CommonResult(444, "账户服务调用异常", null);
    }
}
