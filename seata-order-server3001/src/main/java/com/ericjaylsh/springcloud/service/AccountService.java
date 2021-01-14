package com.ericjaylsh.springcloud.service;

import com.ericjaylsh.springcloud.domain.CommonResult;
import com.ericjaylsh.springcloud.service.impl.AccountServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * @Classname AccountService
 * @Description
 * @Date 2020/9/7 19:28
 * @Created by EricJayLsh
 */
@Component
@FeignClient(value = "seata-account-server", fallback = AccountServiceImpl.class)
public interface AccountService {

    // 调用账户服务的减扣款方法
    @PostMapping("/account/decrease")
    CommonResult decrease(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money);

}
