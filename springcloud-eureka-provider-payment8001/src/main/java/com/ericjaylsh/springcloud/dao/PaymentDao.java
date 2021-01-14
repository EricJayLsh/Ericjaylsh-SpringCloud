package com.ericjaylsh.springcloud.dao;

import com.ericjaylsh.springcloud.domain.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Classname PaymentDao
 * @Description
 * @Date 2020/9/2 11:00
 * @Created by EricJayLsh
 */
@Mapper
public interface PaymentDao {

    int create(@Param("payment") Payment payment);

    Payment getPaymentById(@Param("id") Long id);
}
