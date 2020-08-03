package com.lwjzt.lzcore.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisDemoService {
    @Autowired
    RedisTemplate<String,String> redisTemplate;


    void redisTest() {
        redisTemplate.opsForValue().set("user:1:age","18");
        redisTemplate.opsForValue().set("user:1:name","leexiaobu");
        redisTemplate.opsForValue().set("user:1:des","GOGO");
        String s = redisTemplate.opsForValue().get("user:1:des");
        System.out.println(s);
    }

    public static void main(String[] args) {
        String aa= "äº\u0086ä¸\u008Dèµ·ç\u009A\u0084ç\u009B\u0096è\u008C¨æ¯\u0094";
        StringBuilder stringBuilder = new StringBuilder("key:(");
        System.out.println(aa);
        for (int i = 0; i < aa.length(); i++) {
            aa.charAt(i);
            stringBuilder.append(aa.charAt(i)).append(" OR ");
            System.out.println(aa.charAt(i));
        }
        String end = stringBuilder.append("end").toString().replace(" OR end", ")");
        System.out.println(end);
    }
}
