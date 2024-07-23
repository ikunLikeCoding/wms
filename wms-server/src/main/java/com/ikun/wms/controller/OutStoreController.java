package com.ikun.wms.controller;

import com.github.pagehelper.PageInfo;
import com.ikun.wms.pojo.entity.OutStore;
import com.ikun.wms.pojo.query.OutStoreQuery;
import com.ikun.wms.service.OutStoreService;
import com.ikun.wms.utils.Result;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: yiwang
 * @Date: 2024/7/22
 */

/***
 * 出库管理
 */
@RestController
@RequestMapping("/outstore")
public class OutStoreController {

    @Resource
    private OutStoreService outStoreService;


    @RequestMapping("/outstore/store-list")
    public Result<PageInfo<OutStore>> storeList(OutStoreQuery outStoreQuery) {
        PageInfo<OutStore> pageInfo =outStoreService.findOutStoreByPageAndCondition(outStoreQuery);
        return Result.success(pageInfo);
    }
}
