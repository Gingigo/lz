package com.lwjzt.lzcore.mq.amqb.rabbitmq.tul5;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Tut5Sender {

    @Autowired
    private RabbitTemplate template;

//    @Scheduled(fixedDelay = 1000, initialDelay = 500)
    public void send() {
        String message = " user.save !";
        this.template.convertAndSend("topic","user.save", message);
        System.out.println(" [x] Sent '" + message + "'");
    }
//    @Scheduled(fixedDelay = 1000, initialDelay = 500)
    public void send2() {
        String message = " user.save.info !";
        this.template.convertAndSend("topic","user.save.info", message);
        System.out.println(" [x] Sent '" + message + "'");
    }
//    @Scheduled(fixedDelay = 1000, initialDelay = 500)
    public void send3() {
        String message = " direct !";
        this.template.convertAndSend("topic","user1.save.info", message);
        System.out.println(" [x] Sent '" + message + "'");
    }
}
