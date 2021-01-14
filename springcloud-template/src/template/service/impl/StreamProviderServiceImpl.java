package com.ericjaylsh.springcloud.service.impl;

import com.ericjaylsh.springcloud.service.IStreamProviderService;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @Classname TemplateServiceImpl
 * @Description
 * @Date 2020/9/4 22:48
 * @Created by EricJayLsh
 */
//@Service
// 注意此处不是添加 @Service 注解 stream操作：将信道和交换器exchange绑定
@Component
@EnableBinding(Source.class) // 定义消息推送管道
public class StreamProviderServiceImpl implements IStreamProviderService {


    @Resource
    private MessageChannel outputMessage;  // 消息发送管道

    @Override
    public String send() {
        String uuid = UUID.randomUUID().toString();
        System.out.println("********************** uuid" + uuid);
        outputMessage.send(MessageBuilder.withPayload(uuid).build());
        return "success";
    }
}
