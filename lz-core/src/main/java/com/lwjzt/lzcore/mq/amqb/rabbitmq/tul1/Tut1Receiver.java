package com.lwjzt.lzcore.mq.amqb.rabbitmq.tul1;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queuesToDeclare =@Queue(value = "hello",durable = "true",autoDelete = "false",exclusive = "false") )
public class Tut1Receiver {
    @RabbitHandler
    public void receive(String in) {
        System.out.println(" [x] Received '" + in + "'");
    }
}
