package com.lwjzt.lzcore.controller;

import com.lwjzt.lzcore.CoreApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/checkBean")
public class CheckBeanController {
    @RequestMapping("/byName/{name}")
    public Object byName(@PathVariable("name")String beanName) {
        Object bean = CoreApplication.SpringBeanUtil.getBean(beanName);
        System.out.println(bean);
        return bean;
    }
}
