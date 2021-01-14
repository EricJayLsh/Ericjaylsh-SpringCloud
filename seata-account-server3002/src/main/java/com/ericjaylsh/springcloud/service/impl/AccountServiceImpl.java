package com.ericjaylsh.springcloud.service.impl;

import com.ericjaylsh.springcloud.dao.AccountDao;
import com.ericjaylsh.springcloud.domain.Account;
import com.ericjaylsh.springcloud.domain.CommonResult;
import com.ericjaylsh.springcloud.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Classname AccountServiceImpl
 * @Description
 * @Date 2020/9/7 19:29
 * @Created by EricJayLsh
 */
@Service
public class AccountServiceImpl implements AccountService {


    @Autowired
    AccountDao accountDao;

    @Override
    public CommonResult decrease(Long userId, BigDecimal money) {
        return new CommonResult(200, "账户扣款成功!", accountDao.decrease(userId, money));
    }

    @Override
    public CommonResult selectAll() {
        return new CommonResult(200, "success", accountDao.selectAll());
    }
}
