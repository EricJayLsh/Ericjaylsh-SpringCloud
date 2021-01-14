package com.ericjaylsh.springcloud.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Classname Entity
 * @Description
 * @Date 2020/9/4 22:55
 * @Created by EricJayLsh
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Entity implements Serializable {

    public Long id;

    public String data;
}
