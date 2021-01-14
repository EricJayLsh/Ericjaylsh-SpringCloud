package com.ericjaylsh.springcloud.service.impl;

import com.ericjaylsh.springcloud.dao.PaymentDao;
import com.ericjaylsh.springcloud.domain.Payment;
import com.ericjaylsh.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Classname PaymentServiceImpl
 * @Description
 * @Date 2020/9/2 11:28
 * @Created by EricJayLsh
 */
@Service
public class PaymentServiceImpl implements PaymentService {


    // @Resource 为java自带的注解 也可以实现自动注入
    @Resource
    PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
