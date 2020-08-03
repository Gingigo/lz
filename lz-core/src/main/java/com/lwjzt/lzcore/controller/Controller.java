package com.lwjzt.lzcore.controller;


import com.lwjzt.lzcore.domain.User;
import com.lwjzt.lzcore.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class Controller {
    @Autowired
    UserServiceImpl userService;
    @GetMapping("/list")
    public List<User> list(){
        return userService.list();
    }

    @GetMapping("/hello/{name}")
    public String hello(@PathVariable("name")String name ){
        return new String ("hello,"+name);
    }


}
