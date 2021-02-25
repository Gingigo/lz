package com.lwjzt.lzcore.mybatisplus;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@SpringBootTest
@RunWith(SpringRunner.class)
class MybatisDemoServiceTest {

    @Autowired
    MybatisDemoService mybatisDemoService;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void CRUD() {
//        mybatisDemoService.CRUD();
    }

    @Test
    void CRUD11() throws IOException {
        mybatisDemoService.mcnUser();
    }


    @Autowired
    RabbitTemplate rabbitTemplate;
    @Test
    void send() {
        System.out.println("123");
        rabbitTemplate.convertAndSend("hello", "hello world");
        System.out.println("456");
    }

}
