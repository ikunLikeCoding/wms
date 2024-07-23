package com.ikun.wms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ikun.wms.mapper.StatisticsMapper;
import com.ikun.wms.pojo.dto.Statistics;

import java.util.List;

public interface StatisticsService extends IService<Statistics> {
    public List<Statistics> statisticsStoreInvent();

}
