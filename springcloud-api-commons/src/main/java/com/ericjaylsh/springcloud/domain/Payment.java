package com.ericjaylsh.springcloud.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Classname Payment
 * @Description
 * @Date 2020/9/2 10:42
 * @Created by EricJayLsh
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment implements Serializable {

    public Long id;

    public String serial;

}
