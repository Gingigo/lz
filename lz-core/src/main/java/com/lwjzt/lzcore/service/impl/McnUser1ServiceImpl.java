package com.lwjzt.lzcore.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lwjzt.lzcore.domain.McnUser1;
import java.util.List;
import com.lwjzt.lzcore.mapper.McnUser1Mapper;
import com.lwjzt.lzcore.service.McnUser1Service;

@Service
public class McnUser1ServiceImpl extends ServiceImpl<McnUser1Mapper, McnUser1> implements McnUser1Service {

    @Override
    public int updateBatch(List<McnUser1> list) {
        return baseMapper.updateBatch(list);
    }

    @Override
    public int batchInsert(List<McnUser1> list) {
        return baseMapper.batchInsert(list);
    }

    @Override
    public int insertOrUpdate(McnUser1 record) {
        return baseMapper.insertOrUpdate(record);
    }

    @Override
    public int insertOrUpdateSelective(McnUser1 record) {
        return baseMapper.insertOrUpdateSelective(record);
    }
}

