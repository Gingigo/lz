package com.lwjzt.lzcore.mq.amqb.rabbitmq.tul4;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Tut4Receiver {
    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue,
                    exchange = @Exchange(value = "logs_direct", type = "direct",durable = "false")
                    , key = {"error"}
            )
    })
    public void work1(String in) {
        System.out.println(" [direct1] Received '" + in + "'");
    }

    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue,
                    exchange = @Exchange(value = "logs_direct", type = "direct",durable = "false"),
                    key = {"info", "error"}
            )

    })
    public void work2(String in) {
        System.out.println(" [direct2] Received '" + in + "'");
    }


}
