package com.lwjzt.lzcore.mq.amqb.rabbitmq.tul2;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Tut2Sender {

    @Autowired
    private RabbitTemplate template;

//    @Scheduled(fixedDelay = 1000, initialDelay = 500)
    public void send() {
        String message = " work !";
        this.template.convertAndSend("work", message);
        System.out.println(" [x] Sent '" + message + "'");
    }
}
