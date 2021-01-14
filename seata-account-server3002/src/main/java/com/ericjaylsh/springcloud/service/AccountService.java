package com.ericjaylsh.springcloud.service;

import com.ericjaylsh.springcloud.domain.CommonResult;

import java.math.BigDecimal;

/**
 * @Classname AccountService
 * @Description
 * @Date 2020/9/7 19:28
 * @Created by EricJayLsh
 */
public interface AccountService {

    CommonResult decrease(Long userId, BigDecimal money);

    CommonResult selectAll();
}
