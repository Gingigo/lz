package com.lwjzt.lzcore.service;

import com.lwjzt.lzcore.domain.McnUser1;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.IService;

public interface McnUser1Service extends IService<McnUser1> {


    int updateBatch(List<McnUser1> list);

    int batchInsert(List<McnUser1> list);

    int insertOrUpdate(McnUser1 record);

    int insertOrUpdateSelective(McnUser1 record);

}

