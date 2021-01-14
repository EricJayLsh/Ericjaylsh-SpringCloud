package com.ericjaylsh.springcloud.config;

import org.springframework.context.annotation.Configuration;

import javax.annotation.ManagedBean;

/**
 * @Classname MybatisConfig
 * @Description
 * @Date 2020/9/7 20:08
 * @Created by EricJayLsh
 */
@Configuration
@ManagedBean(value = "com.ericjaylsh.springcloud.dao")
public class MybatisConfig {
}
