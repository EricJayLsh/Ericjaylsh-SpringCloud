package com.ericjaylsh.springcloud.service;

import com.ericjaylsh.springcloud.domain.CommonResult;

/**
 * @Classname StorageService
 * @Description
 * @Date 2020/9/7 19:29
 * @Created by EricJayLsh
 */
public interface StorageService {

    CommonResult decrease(Long productId, Integer count);

    CommonResult selectAll();
}
