package com.ericjaylsh.springcloud.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Classname CommonResult
 * @Description
 * @Date 2020/9/2 10:56
 * @Created by EricJayLsh
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {

    private Integer code;
    private String massage;
    private T data;

    public CommonResult(Integer code, String massage) {
        this(code, massage, null);
    }
}
