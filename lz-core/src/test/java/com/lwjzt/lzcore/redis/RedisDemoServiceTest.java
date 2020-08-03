package com.lwjzt.lzcore.redis;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
class RedisDemoServiceTest {
    @Autowired
    RedisDemoService redisDemoService;


    @Test
    void redisTest() {
        redisDemoService.redisTest();
    }
}