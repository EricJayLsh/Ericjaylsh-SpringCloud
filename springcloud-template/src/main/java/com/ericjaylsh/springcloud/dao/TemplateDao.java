package com.ericjaylsh.springcloud.dao;

/**
 * @Classname TemplateDao
 * @Description
 * @Date 2020/9/2 11:00
 * @Created by EricJayLsh
 */
//@Mapper
public interface TemplateDao {

//    int create(@Param("payment") Payment payment);
//
//    Payment getPaymentById(@Param("id") Long id);

    String template(Long id);
}
