package com.lwjzt.lzcore;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lwjzt.lzcore.domain.User;
import com.lwjzt.lzcore.mapper.UserMapper;
import com.lwjzt.lzcore.mybatisplus.MybatisDemoService;
import com.lwjzt.lzcore.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
class CoreApplicationTests {

    @Autowired
    UserServiceImpl userService;

    @Autowired
    UserMapper userMapper;
    @Test
    void contextLoads() {
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        List<User> users = userMapper.selectList(userQueryWrapper);
        int size = users.size();
        System.out.println(size);
        List<User> list = userService.list();
        System.out.println(list);
        MybatisDemoService mybatisDemoService =new MybatisDemoService();
        mybatisDemoService.CRUD();
    }

}
