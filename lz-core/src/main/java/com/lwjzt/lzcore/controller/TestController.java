package com.lwjzt.lzcore.controller;

import com.lwjzt.lzcore.mybatisplus.MybatisDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    MybatisDemoService mybatisDemoService;
    @GetMapping("/mybatis")
    public void testMybatis() {
       mybatisDemoService.CRUD();
    }
}
