package com.lwjzt.lzcore.mq.amqb.rabbitmq.tul3;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Tut3Receiver {
    @RabbitListener(bindings = {
        @QueueBinding(value = @Queue,exchange = @Exchange(value = "logs",type = "fanout"))
    })
    public void work1(String in) {
        System.out.println(" [fan_out1] Received '" + in + "'");
    }

    @RabbitListener(bindings = {
            @QueueBinding(value = @Queue,exchange = @Exchange(value = "logs",type = "fanout"))
    })
    public void work2(String in) {
        System.out.println(" [fan_out2] Received '" + in + "'");
    }




}
