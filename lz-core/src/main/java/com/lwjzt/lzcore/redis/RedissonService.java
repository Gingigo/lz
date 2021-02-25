package com.lwjzt.lzcore.redis;

import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author Leexiaobu
 * @date 2020-10-30 18:15:48
 */
@Component
@Slf4j
public class RedissonService {
    @Autowired
    RedissonClient redissonClient;

   public void getLock() {
        RLock order = redissonClient.getLock("order");
        log.info("进入方法");
        try {
            order.lock(30, TimeUnit.SECONDS);
            log.info("get Lock");
            Thread.sleep(10000);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            log.info(" release lock");
            order.unlock();
        }
    }
}
