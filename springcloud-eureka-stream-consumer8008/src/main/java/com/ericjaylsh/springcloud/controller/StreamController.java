package com.ericjaylsh.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Classname TemplateController
 * @Description
 * @Date 2020/9/4 22:47
 * @Created by EricJayLsh
 */
@Component
@EnableBinding(Sink.class)
public class StreamController {

    @Value("${server.port}")
    private String serverPort;


    @StreamListener(Sink.INPUT)
    public void getId(Message<String> massage) {
        System.out.println("收到消息：" + massage.getPayload() + "\t  端口号：" + serverPort);
    }

    @GetMapping(value = "/hello")
    public String hello() {
        return "hello";
    }


}
