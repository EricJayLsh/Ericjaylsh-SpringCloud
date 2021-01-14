package com.ericjaylsh.springcloud.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Classname Account
 * @Description
 * @Date 2020/9/8 10:04
 * @Created by EricJayLsh
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account implements Serializable {

    public Long id;

    public Long userId;

    public BigDecimal money;
}
