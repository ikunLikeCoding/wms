package com.ikun.wms.controller;

import com.ikun.wms.pojo.entity.Store;
import com.ikun.wms.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ikun.wms.service.StoreService;

import java.util.List;

@RestController
@RequestMapping("/instore")
public class InstoreController {
    @Autowired
    private StoreService StoreService;
    /**
     * 获取所有商品
     */
    @RequestMapping("/store-list")
    public Result storeList(){
        List<Store> storeList = StoreService.list();
        return Result.success(storeList);
    }

}
