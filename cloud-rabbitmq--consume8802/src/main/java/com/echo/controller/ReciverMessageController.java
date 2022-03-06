package com.echo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/*
stream 消息的消费段 使用sink进行消息的消费
 */
@Component
@EnableBinding(Sink.class)
public class ReciverMessageController {

    @Value("${server.port}")
    private String port;

    // 对消息进行监听
    /*
    生产端使用 MessageBuilder.withPayload(serial) 进行消息的发送
     */

    @StreamListener(Sink.INPUT)
    public void input(Message<String> message) {
        System.out.println("消费端1号" + message.getPayload() + "\t" + port);
    }

}
