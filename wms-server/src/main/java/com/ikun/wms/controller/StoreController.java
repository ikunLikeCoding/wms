package com.ikun.wms.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ikun.wms.mapper.StoreMapper;
import com.ikun.wms.pojo.entity.Store;
import com.ikun.wms.pojo.query.StoreQuery;
import com.ikun.wms.service.StoreService;
import com.ikun.wms.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: yiwang
 * @Date: 2024/7/22
 */

/***
 * 仓库管理
 */
@RequestMapping("/store")
@RestController
public class StoreController {
    @Autowired
    private StoreService storeService;

    /**
     * 分页查询仓库表单
     * @return
     */
    @RequestMapping("/store-page-list")
    public Result<PageInfo<Store> > storePageList(StoreQuery storeQuery) {
        System.out.println(storeQuery);
        PageHelper.startPage(storeQuery.getCurrentPage(), storeQuery.getPageSize());
        PageInfo<Store> pageInfo = new PageInfo<>(storeService.findPageStore(storeQuery));
        return Result.success(pageInfo);
    }
    /**
     * 仓库编号唯一性校验
     * @param storeNum
     * @return
     */
    @RequestMapping("/store-num-check")
    public Result storeNumCheck(String storeNum) {
        Store store= storeService.findStoreByNum(storeNum);
        return Result.success(store==null);//存在返回false，不存在返回true
    }
    /**
     * 添加仓库
     * @param store
     * @return
     */
    @RequestMapping("/store-add")
    public Result storeAdd(@RequestBody Store store) {
        storeService.save(store);
        return Result.success();
    }
    /**
     * 修改仓库
     * @param store
     * @return
     */
    @RequestMapping("/store-update")
    public Result storeUpdate(@RequestBody Store store) {
        storeService.updateById(store);
        return Result.success();
    }

    /**
     * 仓库删除
     * @param storeId
     * @return
     */
    @RequestMapping("/store-delete")
    public Result storeDelete(@RequestParam("storeId") Integer storeId) {
        storeService.removeById(storeId);
        return Result.success();
    }

}
