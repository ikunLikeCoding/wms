package com.ikun.wms.controller;

import com.ikun.wms.utils.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/***
 * 入库管理
 */
@RestController
@RequestMapping("/instore")
public class InStoreController {
    @RequestMapping("/instore")
    public String InStore(){
        return "instore";
    }

    @RequestMapping("/store-list")
    public Result storeList(){

        return Result.success();
    }


}
