package com.ericjaylsh.springcloud.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;


/**
 * @Classname CustomerRoundRobinRuleService
 * @Description
 * @Date 2020/9/3 11:10
 * @Created by EricJayLsh
 */
@Service
public class CustomerRoundRobinRuleService implements ICustomerRoundRobinRule {

    @Autowired
    DiscoveryClient discoveryClient;

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    public final int getAndIncrement() {
        int current;
        int next;
        do {
            current = this.atomicInteger.get();
            next = current >= 2147483647 ? 0 : current + 1;
        } while (!this.atomicInteger.compareAndSet(current, next));
        System.out.println("*****第几次访问，次数next: " + next);
        return next;
    }


    @Override
    public ServiceInstance getCustomerRoundRobinRule(String applicationServerName) {

        List<ServiceInstance> serviceInstances = discoveryClient.getInstances(applicationServerName.toUpperCase());
        if (serviceInstances != null && !serviceInstances.isEmpty()) {
            ServiceInstance serviceInstance = serviceInstances.get(getAndIncrement() % serviceInstances.size());
            System.out.println("Uri: " + serviceInstance.getUri());
            System.out.println("Host: " + serviceInstance.getHost());
            System.out.println("Port: " + serviceInstance.getPort());
            return serviceInstance;
        }
        return null;
    }
}
