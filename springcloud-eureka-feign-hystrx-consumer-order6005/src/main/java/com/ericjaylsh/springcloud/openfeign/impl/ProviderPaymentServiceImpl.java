package com.ericjaylsh.springcloud.openfeign.impl;

import com.ericjaylsh.springcloud.openfeign.IProviderPaymentService;
import org.springframework.stereotype.Service;

/**
 * @Classname ProviderPaymentServiceImpl
 * @Description
 * @Date 2020/9/3 18:27
 * @Created by EricJayLsh
 */

// 统一服务降级、熔断处理
@Service
public class ProviderPaymentServiceImpl implements IProviderPaymentService {
    @Override
    public String testOk() {
        return "服务异常繁忙，请稍后再试~！ProviderPaymentServiceImpl.testOk()";
    }

    @Override
    public String timeOut() {
        return "服务异常繁忙，请稍后再试~！ProviderPaymentServiceImpl.timeOut()";
    }
}
