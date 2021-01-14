package com.ericjaylsh.springcloud.service.impl;

import com.ericjaylsh.springcloud.service.IStreamProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import java.util.UUID;

//import org.springframework.integration.support.MessageBuilder;

/**
 * @Classname TemplateServiceImpl
 * @Description
 * @Date 2020/9/4 22:48
 * @Created by EricJayLsh
 */
//@Service
@EnableBinding(Source.class) // 定义消息推送管道
public class StreamProviderServiceImpl implements IStreamProviderService {

    @Autowired
    private MessageChannel output;  // 消息发送管道 注意output变量只能是这个名字否则报错

   /* Field outputMessage in com.ericjaylsh.springcloud.service.impl.StreamProviderServiceImpl required a single bean, but 3 were found:
            - output: defined by method 'output' in null
            - nullChannel: defined in null
            - errorChannel: defined in null
*/

 /*
   @Autowired
    private Source source; //注入接口和注入MessageChannel的区别在于发送时需不需要调用接口内的方法
    */

    @Override
    public String send() {
        String uuid = UUID.randomUUID().toString();
        System.out.println("********************** uuid" + uuid);
        output.send(MessageBuilder.withPayload(uuid).build());
//        source.output().send(MessageBuilder.withPayload(uuid).build());  此方法和上方法雷同
        return "success";
    }
}
