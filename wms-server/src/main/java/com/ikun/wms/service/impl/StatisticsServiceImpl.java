package com.ikun.wms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ikun.wms.mapper.StatisticsMapper;
import com.ikun.wms.pojo.dto.Statistics;
import com.ikun.wms.service.StatisticsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatisticsServiceImpl extends ServiceImpl<StatisticsMapper, Statistics> implements StatisticsService {
    public List<Statistics> statisticsStoreInvent() {
        return baseMapper.statisticsStoreInvent();
    }

}
