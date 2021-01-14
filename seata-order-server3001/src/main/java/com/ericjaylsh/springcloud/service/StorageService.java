package com.ericjaylsh.springcloud.service;

import com.ericjaylsh.springcloud.domain.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Classname StorageService
 * @Description
 * @Date 2020/9/7 19:29
 * @Created by EricJayLsh
 */
@Component
@FeignClient(value = "seata-storage-server")
public interface StorageService {

    // 调用库存服务的减库存方法
    @PostMapping("/storage/decrease")
    CommonResult decrease(@RequestParam("productId") Long productId, @RequestParam("count") Integer count);
}
