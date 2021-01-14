package com.ericjaylsh.springcloud.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Classname Order
 * @Description
 * @Date 2020/9/4 22:55
 * @Created by EricJayLsh
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order implements Serializable {

    public Long id;

    public Long userId;

    public Long productId;

    public Integer count;

    public BigDecimal money;

    public Integer status;
}
