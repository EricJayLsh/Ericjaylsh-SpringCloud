package com.ericjaylsh.springcloud.service;

import com.ericjaylsh.springcloud.domain.Payment;

/**
 * @Classname PaymentService
 * @Description
 * @Date 2020/9/2 11:28
 * @Created by EricJayLsh
 */
public interface PaymentService {

    int create(Payment payment);

    Payment getPaymentById(Long id);
}
