package com.lwjzt.lzcore.mybatisplus;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.lwjzt.lzcore.domain.User;
import com.lwjzt.lzcore.mapper.UserMapper;
import com.lwjzt.lzcore.service.impl.UserServiceImpl;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Data
@Service
@Slf4j
public class MybatisDemoService {
    @Autowired
    UserServiceImpl userService;
    @Autowired
    UserMapper userMapper;

    public void CRUD() {
        userService.list().stream().map((user)->{
            System.out.println(user);
            return user;
        }).count();
        User user = userMapper.selectById(1);
        log.info(user.toString());
//        user.setUserName("LEEDABU");
//        userMapper.updateById(user);
    }
}
