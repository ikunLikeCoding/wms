package com.ikun.wms.controller;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.github.pagehelper.PageInfo;
import com.ikun.wms.pojo.entity.OutStore;
import com.ikun.wms.pojo.query.OutStoreQuery;
import com.ikun.wms.service.OutStoreService;
import com.ikun.wms.utils.Result;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

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

    private static final Logger log = LoggerFactory.getLogger(OutStoreController.class);
    @Resource
    private OutStoreService outStoreService;


    @GetMapping("/outstore-page-list")
    public Result<PageInfo<OutStore>> storeList(OutStoreQuery outStoreQuery) {
        System.out.println("outStoreQuery"+outStoreQuery);
        PageInfo<OutStore> pageInfo =outStoreService.findOutStoreByPageAndCondition(outStoreQuery);
        return Result.success(pageInfo);
    }

    @PutMapping("/outstore-confirm")
    public Result outStoreConfirm(@RequestBody OutStore outStore) {
        log.info("outstore-confirm{}",outStore);


        outStoreService.confirmOutStore(outStore);

        return Result.success();
    }


}
