package com.ericjaylsh.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.ericjaylsh.springcloud.handler.Myfallback;
import com.ericjaylsh.springcloud.handler.MylockHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * @Classname TemplateController
 * @Description 流控模式：
 * 1. QPS(每秒请求数量)（还未进入服务端处理）
 * 2. 线程数（服务端处理的线程数量）
 * <p>
 * 关联：A关联B， 当B请求达到A阈值时 就限制A
 * 预热：最初阈值为 阈值/3 经过一段预热时间之后 阈值才变为原值
 * 排队等待：当有多个请求时，只按照阈值请求数处理 （例如每分钟只处理5个请求 均匀处理）
 * <p>
 * RT: 请求数>5 并且响应时间大约阈值 则在时间窗口期内熔断
 * 异常比例：请求数>5 并且异常数大于阈值比例 则在时间窗口期内熔断
 * 异常数：一分钟内异常数大于阈值比例 则在时间窗口期内熔断（时间窗口期应大于一分钟）
 * <p>
 * 热点key： 当限流的参数访问超过阈值时  则在时间窗口期内降级（访问blockHandler指定的方法，若未指定 则抛出异常）
 * 配置参数例外项 当参数是某个特定值时，可以修改QPS
 * @Date 2020/9/4 22:47
 * @Created by EricJayLsh
 */
@RestController
@RequestMapping("/sentinel")
@Slf4j
public class TemplateController {


    @Value("${server.port}")
    private String serverPort;


    @GetMapping(value = "/get/{id}")
    public String getId(@PathVariable Long id) {
        return "端口： " + serverPort;
    }

    @GetMapping(value = "/test1")
    public String test1() {
        // 模拟后端线程数限流，当阈值内的线程数出来不过来请求时 报错
        /*try {
            Thread.sleep(800);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        return "test1： " + serverPort;
    }

    @GetMapping(value = "/test2")
    public String test2() {
        System.out.println(Thread.currentThread().getName() + "演示排队等待");
        return "test2： 排队等待演示" + serverPort;
    }


    @GetMapping(value = "/test3")
    public String test3() {

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "test3： RT演示" + serverPort;
    }

    @GetMapping(value = "/test4")
    public String test4() {
        int a = 10 / 0;
        return "test4： 异常比例演示/异常数演示" + serverPort;
    }


    @GetMapping(value = "/hotKey")
    @SentinelResource(value = "hotKey", blockHandler = "block_function") // 只处理sentinel 中配置的规则，若程序抛出异常 blockHandler 不处理
    public String hotKey(@RequestParam(value = "p1", required = false) String p1, @RequestParam(value = "p2", required = false) String p2) {
        return "hotKey： hotKey测试  p1 ,p2" + p1 + p2;
    }

    public String block_function(String p1, String p2, BlockException block) {
        return "hotKey： block_function p1 ,p2" + p1 + p2;
    }


    @GetMapping(value = "/limitSentinelResource/{id}") // blockHandler 负责限流 熔断等规则 fallback 负责程序异常 当两个都满足时 blockHandler优先触发
    @SentinelResource(value = "limitSentinelResource",
            blockHandlerClass = MylockHandler.class,
            blockHandler = "customerHandler1",
            fallbackClass = Myfallback.class,
            fallback = "fallback1",
            exceptionsToIgnore = {RuntimeException.class}       // fallback 处理时忽略 RuntimeException
    )
    public String limitSentinelResource(@PathVariable(value = "id", required = false) String id){
        if("e".equals(id)){
            throw new NullPointerException("空指针异常！");
        }
        return "limitSentinelResource： 资源名称限流 测试，使用公有类中的降级方法 customerHandler1() ";
    }


}
