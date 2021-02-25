package com.lwjzt.lzcore.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lwjzt.lzcore.domain.McnUser1;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface McnUser1Mapper extends BaseMapper<McnUser1> {
    int updateBatch(List<McnUser1> list);

    int batchInsert(@Param("list") List<McnUser1> list);

    int insertOrUpdate(McnUser1 record);

    int insertOrUpdateSelective(McnUser1 record);
}