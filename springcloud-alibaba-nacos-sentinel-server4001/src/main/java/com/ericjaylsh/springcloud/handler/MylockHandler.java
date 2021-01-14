package com.ericjaylsh.springcloud.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;

/**
 * @Classname MylockHandler
 * @Description
 * @Date 2020/9/7 14:36
 * @Created by EricJayLsh
 */
public class MylockHandler {

    public String customerHandler1(BlockException block) {

        return "降级方法： customerHandler1()";
    }

    public String customerHandler2(BlockException block) {

        return "降级方法： customerHandler2()";
    }

    public String customerHandler3(BlockException block) {

        return "降级方法： customerHandler3()";
    }
}
