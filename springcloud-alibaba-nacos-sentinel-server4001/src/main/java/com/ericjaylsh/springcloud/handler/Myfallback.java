package com.ericjaylsh.springcloud.handler;

/**
 * @Classname Myfallback
 * @Description
 * @Date 2020/9/7 15:18
 * @Created by EricJayLsh
 */
public class Myfallback {

    public String fallback1(Throwable throwable) {

        return "程序异常降价方法： fallback1() 异常是：" + throwable.getMessage();
    }

    public String fallback2(Throwable throwable) {

        return "程序异常降价方法： fallback2() 异常是：" + throwable.getMessage();
    }

    public String fallback3(Throwable throwable) {

        return "程序异常降价方法： fallback3() 异常是：" + throwable.getMessage();
    }
}
