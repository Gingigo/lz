package com.lwjzt.lzcore.controller;

import com.lwjzt.lzcore.redis.RedissonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Leexiaobu
 * @date 2020-10-30 18:14:04
 */
@RestController
@RequestMapping("/redisson")
public class RedissonController {
    @Autowired
    RedissonService redissonService;

    @GetMapping("/getLock")
    void getLock() {
        redissonService.getLock();
    }

    @GetMapping("/test")
    public String helloWorld(){
        return "hello World";
    }

}
