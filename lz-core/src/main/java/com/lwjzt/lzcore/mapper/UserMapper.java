package com.lwjzt.lzcore.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lwjzt.lzcore.domain.User;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface UserMapper extends BaseMapper<User> {
    int updateBatch(List<User> list);

    int batchInsert(@Param("list") List<User> list);

    int insertOrUpdate(User record);

    int insertOrUpdateSelective(User record);
}