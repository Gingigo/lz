package com.lwjzt.lzcore.mybatis.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Leexiaobu
 * @date 2020-10-18 17:57:14
 */
@SpringBootTest
@RunWith(SpringRunner.class)
class MybatisTest {
    @Before
    public void init() {

    }

    public static void main(String[] args) {
        System.out.println(test(10));
        System.out.println(test(8));
        System.out.println(test(5));
    }

   static char test(int i) {
        return i > 6 ?
                i > 9 ? 'A' : 'B'
                : 'C';
    }


}