package com.ericjaylsh.springcloud.openfeign;

import com.ericjaylsh.springcloud.domain.CommonResult;
import com.ericjaylsh.springcloud.domain.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Classname IProviderPaymentService
 * @Description
 * @Date 2020/9/3 12:56
 * @Created by EricJayLsh
 */

@Component
@FeignClient(value = "SPRINGCLOUD-PROVIDER-PAYMENT")  // 注册中心上想要调用的服务名称value = "SPRINGCLOUD-PROVIDER-PAYMENT"
public interface IProviderPaymentService {

    // openfeign 支持 springMvc 的注解

    String PROVIDER = "/provider";

    @GetMapping(value = PROVIDER + "/create")
    CommonResult<Payment> create(Payment payment);

    // 注意此处 @PathVariable 注解 必须添加 (value = "id") 属性 否则报错，但是这个值在 controller 中可以省略
    @GetMapping(value = PROVIDER + "/getPaymentById/{id}")
    CommonResult<Payment> getPaymentById(@PathVariable(value = "id") Long id);

    @GetMapping(value = PROVIDER + "/timeOut")
    String timeOut();

}
