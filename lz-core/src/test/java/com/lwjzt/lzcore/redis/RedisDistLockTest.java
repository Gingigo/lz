package com.lwjzt.lzcore.redis;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Leexiaobu
 * @date 2020-10-30 12:13:58
 */
@SpringBootTest
@RunWith(SpringRunner.class)
class RedisDistLockTest {
    @Autowired
    RedisDistLock redisDistLock;

    @Test
    void getLock() throws InterruptedException {
//        RedisDistLock redisDistLock = new RedisDistLock();
        System.out.println(redisDistLock);
        for (int i = 0; i < 3; i++) {
            new Threadtest(redisDistLock).start();
        }
    Thread.sleep(100000);

    }


}

class Threadtest extends Thread {
    RedisDistLock redisDistLock;
    public Threadtest(RedisDistLock redisDistLock) {
        this.redisDistLock = redisDistLock;
    }

    @Override
    public void run() {
        redisDistLock.getLock();
    }
}