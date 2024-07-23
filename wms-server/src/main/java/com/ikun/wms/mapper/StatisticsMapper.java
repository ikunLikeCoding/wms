package com.ikun.wms.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ikun.wms.pojo.dto.Statistics;

import java.util.List;

public interface StatisticsMapper extends BaseMapper<Statistics> {
    List<Statistics> statisticsStoreInvent();
}
