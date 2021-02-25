package com.lwjzt.lzcore.mq.amqb.rabbitmq.tul5;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Tut5Receiver {
    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue,
                    exchange = @Exchange(value = "topic", type = "topic",durable = "false")
                    , key = {"user.#"}
            )
    })
    public void work1(String in) {
        System.out.println(" [topic 1] Received '" + in + "'");
    }

    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue,
                    exchange = @Exchange(value = "topic", type = "topic",durable = "false"),
                    key = {"user.*", "error"}
            )

    })
    public void work2(String in) {
        System.out.println(" [topic 2] Received '" + in + "'");
    }


}
