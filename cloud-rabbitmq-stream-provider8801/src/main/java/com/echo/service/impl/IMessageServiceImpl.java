package com.echo.service.impl;

import com.echo.service.IMessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.MessageChannel;
import org.springframework.integration.support.MessageBuilder;
import javax.annotation.Resource;
import org.springframework.cloud.stream.messaging.Source;
import java.util.UUID;


@EnableBinding(Source.class)    // 生产者通过 Source将消息发送到 channel
@Slf4j
public class IMessageServiceImpl implements IMessageService {
//    // 使用stream 在mq 间进行消息的发送 类似于一个发送消息的接口，和传统的service不同,
//    @Resource
//    private MessageChannel messageChannel;
//
//    @Override
//    public String sendMessage() {
//        String serialId = UUID.randomUUID().toString();
//        log.info(serialId);
//        messageChannel.send(MessageBuilder.withPayload(serialId).build());
//        return serialId;
//    }

    @Resource
    private MessageChannel  output; // 发送消息的管道的名称 对应 application.yml文件中的 绑定的管道  output

    @Override
    public String sendMessage() {
        String serial = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(serial).build());
        System.out.println("*****serial: " + serial);
        return null;
    }

}
