package com.ericjaylsh.springcloud.openfeign;

import com.ericjaylsh.springcloud.openfeign.impl.ProviderPaymentServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Classname IProviderPaymentService
 * @Description
 * @Date 2020/9/3 12:56
 * @Created by EricJayLsh
 */

@Component
@FeignClient(value = "SPRINGCLOUD-EUREKA-HYSTRIX-PROVIDER-PAYMENT", fallback = ProviderPaymentServiceImpl.class)
public interface IProviderPaymentService {

    String PROVIDER = "/provider";

    @GetMapping(value = PROVIDER + "/ok")
    String testOk();


    @GetMapping(value = PROVIDER + "/error")
    String timeOut();

}
