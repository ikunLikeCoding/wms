package com.ikun.wms.controller;

import com.ikun.wms.service.StatisticsService;
import com.ikun.wms.service.StoreService;
import com.ikun.wms.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: yiwang
 * @Date: 2024/7/22
 */

/***
 * 统计
 */
@RestController
@RequestMapping("statistics")
public class StatisticsController {
    @Autowired
    private StatisticsService statisticsService;

    @RequestMapping("/store-invent")
    public Result storeInvent(){
        return Result.success(statisticsService.statisticsStoreInvent());
    }
}
