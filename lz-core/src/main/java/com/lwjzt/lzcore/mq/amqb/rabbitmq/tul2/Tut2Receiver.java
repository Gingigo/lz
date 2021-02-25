package com.lwjzt.lzcore.mq.amqb.rabbitmq.tul2;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Tut2Receiver {
    @RabbitListener(queuesToDeclare = @Queue("work"))
    public void work1(String in) {
        System.out.println(" [work1] Received '" + in + "'");
    }

    @RabbitListener(queuesToDeclare = @Queue("work"))
    public void work2(String in) {
        System.out.println(" [work2] Received '" + in + "'");
    }




}
