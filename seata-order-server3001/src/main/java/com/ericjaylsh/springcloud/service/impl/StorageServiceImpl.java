package com.ericjaylsh.springcloud.service.impl;

import com.ericjaylsh.springcloud.domain.CommonResult;
import com.ericjaylsh.springcloud.service.StorageService;
import org.springframework.stereotype.Service;

/**
 * @Classname StorageServiceImpl
 * @Description
 * @Date 2020/9/7 19:30
 * @Created by EricJayLsh
 */
@Service
public class StorageServiceImpl implements StorageService {


    @Override
    public CommonResult decrease(Long productId, Integer count) {
        return new CommonResult(444, "库存服务调用异常", null);
    }
}
