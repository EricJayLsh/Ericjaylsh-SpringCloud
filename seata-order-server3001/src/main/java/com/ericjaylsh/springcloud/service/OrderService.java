package com.ericjaylsh.springcloud.service;

import com.ericjaylsh.springcloud.domain.CommonResult;
import com.ericjaylsh.springcloud.domain.Order;

/**
 * @Classname OrderService
 * @Description
 * @Date 2020/9/7 19:27
 * @Created by EricJayLsh
 */
public interface OrderService {

    void create(Order order);

    CommonResult selectAll();

}
