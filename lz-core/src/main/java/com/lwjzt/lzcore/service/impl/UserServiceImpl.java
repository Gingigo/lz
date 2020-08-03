package com.lwjzt.lzcore.service.impl;

import com.lwjzt.lzcore.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lwjzt.lzcore.domain.User;
import com.lwjzt.lzcore.mapper.UserMapper;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public int updateBatch(List<User> list) {
        return baseMapper.updateBatch(list);
    }

    @Override
    public int batchInsert(List<User> list) {
        return baseMapper.batchInsert(list);
    }

    @Override
    public int insertOrUpdate(User record) {
        return baseMapper.insertOrUpdate(record);
    }

    @Override
    public int insertOrUpdateSelective(User record) {
        return baseMapper.insertOrUpdateSelective(record);
    }
}



