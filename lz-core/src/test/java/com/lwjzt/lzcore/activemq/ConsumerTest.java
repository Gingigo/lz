package com.lwjzt.lzcore.activemq;

import com.lwjzt.lzcore.mq.jms.activemq.Producer;
import com.lwjzt.lzcore.mq.jms.activemq.Publisher;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
class ConsumerTest {

    @Resource
    private Producer producer;
    @Resource
    private Publisher publisher;

    @Test
    public void contextLoads() {
        for (int i = 0; i < 10; i++) {
            producer.sendMsg("test.queue1", "Queue Message " + i);
        }
    }


    @Test
    public void testTopic() {
        for (int i = 0; i < 10; i++) {
            publisher.sendMsg("test.topic1", "topic Message " + i);
        }
    }
}