package com.ikun.wms.controller;

import com.github.pagehelper.PageInfo;
import com.ikun.wms.pojo.entity.InStore;
import com.ikun.wms.pojo.entity.Store;
import com.ikun.wms.pojo.query.InStoreQuery;
import com.ikun.wms.pojo.vo.InStoreVO;
import com.ikun.wms.service.InStoreService;
import com.ikun.wms.utils.Result;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import com.ikun.wms.service.StoreService;

import java.util.List;

@RestController
@RequestMapping("/instore")
public class InStoreController {
    @Resource
    private StoreService StoreService;

    @Resource
    private InStoreService inStoreService;
    /**
     * 获取所有商品
     */
    @RequestMapping("/store-list")
    public Result storeList(){
        List<Store> storeList = StoreService.list();
        return Result.success(storeList);
    }

    @RequestMapping("/store-page-list")
    public Result<PageInfo<InStoreVO>> storePageList(InStoreQuery inStoreQuery){
        System.out.println(inStoreQuery);
        System.out.println(inStoreQuery.getCurrentPage());
        PageInfo<InStoreVO> storeByPageAndCondition = StoreService.findStoreByPageAndCondition(inStoreQuery);

        return Result.success(storeByPageAndCondition);
    }


    @PutMapping("/instore-confirm")
    public Result inStoreConfirm(@RequestBody InStore inStore){
        System.out.println("inStore"+inStore);
        Integer i = inStoreService.confirmInStore(inStore);
        if (i == 0){
            return Result.error("入库失败");
        }
        return Result.success();
    }

}
