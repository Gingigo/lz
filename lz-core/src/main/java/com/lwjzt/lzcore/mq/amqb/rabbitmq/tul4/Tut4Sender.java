package com.lwjzt.lzcore.mq.amqb.rabbitmq.tul4;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Tut4Sender {

    @Autowired
    private RabbitTemplate template;

//    @Scheduled(fixedDelay = 1000, initialDelay = 500)
    public void send() {
        String message = " direct !";
        this.template.convertAndSend("logs_direct","info", message);
        System.out.println(" [x] Sent '" + message + "'");
    }
//    @Scheduled(fixedDelay = 1000, initialDelay = 500)
    public void send2() {
        String message = " direct !";
        this.template.convertAndSend("logs_direct","error", message);
        System.out.println(" [x] Sent '" + message + "'");
    }
}
