package com.lwjzt.lzcore.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisStringCommands;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.data.redis.core.types.Expiration;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.UUID;

/**
 * @author Leexiaobu
 * @date 2020-10-30 10:35:24
 */
@Component
public class RedisDistLock {
    @Autowired
    RedisOperator redisOperator;

    @Autowired
    RedisTemplate redisTemplate;

    void getLock() {
        System.out.println("init ...");
        String key = "redisKey";
        String value = UUID.randomUUID().toString();
        RedisCallback<Boolean> redisCallback = redisConnection -> {
            RedisStringCommands.SetOption setOption = RedisStringCommands.SetOption.ifAbsent();
            byte[] serializeKey = redisTemplate.getKeySerializer().serialize(key);
            byte[] serializeValue = redisTemplate.getKeySerializer().serialize(value);
            return redisConnection.set(serializeKey, serializeValue, Expiration.seconds(30), setOption);
        };
        Boolean lock = (Boolean) redisTemplate.execute(redisCallback);
        if (lock) {
            System.out.println("get Lock！");
            try {
                Thread.sleep(15000);
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            } finally {
                String script = "if redis.call(\"get\",KEYS[1]) == ARGV[1] then\n" +
                        "    return redis.call(\"del\",KEYS[1])\n" +
                        "else\n" +
                        "    return 0\n" +
                        "end";
                RedisScript<Boolean> redisScript = RedisScript.of(script, Boolean.class);
                Boolean execute = (Boolean) redisTemplate.execute(redisScript, Arrays.asList(key), value);
                System.out.println(" lock end " + execute);
            }
        }
        System.out.println("lock out");
    }

}
