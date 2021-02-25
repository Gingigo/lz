package com.lwjzt.lzcore.mq.amqb.rabbitmq.tul3;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Tut3Sender {

    @Autowired
    private RabbitTemplate template;

//    @Scheduled(fixedDelay = 1000, initialDelay = 500)
    public void send() {
        String message = " fanout !";
        this.template.convertAndSend("logs","", message);
        System.out.println(" [x] Sent '" + message + "'");
    }
}
