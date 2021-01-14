package com.ericjaylsh.springcloud.customer;

import org.springframework.cloud.client.ServiceInstance;

/**
 * @Classname ICustomerRoundRobinRule
 * @Description
 * @Date 2020/9/3 11:10
 * @Created by EricJayLsh
 */
public interface ICustomerRoundRobinRule {

    ServiceInstance getCustomerRoundRobinRule(String applicationServerName);

}
