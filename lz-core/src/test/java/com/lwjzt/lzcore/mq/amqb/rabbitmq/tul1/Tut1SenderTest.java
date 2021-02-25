package com.lwjzt.lzcore.mq.amqb.rabbitmq.tul1;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * @author Leexiaobu
 * @date 2020-10-28 22:20:51
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class Tut1SenderTest {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Test
    void send() {
        System.out.println("123");
        rabbitTemplate.convertAndSend("hello", "hello world");
        System.out.println("456");
    }
}