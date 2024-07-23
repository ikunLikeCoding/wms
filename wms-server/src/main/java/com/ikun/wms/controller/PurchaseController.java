package com.ikun.wms.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ikun.wms.pojo.entity.BuyList;
import com.ikun.wms.pojo.entity.InStore;
import com.ikun.wms.service.BuyListService;
import com.ikun.wms.service.StoreService;
import com.ikun.wms.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {
    @Autowired
    private BuyListService buyListService;
    @Autowired
    private StoreService storeService;
    /**
     * 采购添加
     * @param buyList
     * @return
     */
    @RequestMapping("/purchase-add")
    public Result purchaseAdd(@RequestBody BuyList buyList) {
        buyListService.purchaseAdd(buyList);
        return Result.success();
    }
    @RequestMapping("/purchase-list")
    public Result storeList(){
        return Result.success(storeService.list());
    }

    /**
     * 分页查询
     * @param currentPage
     * @param pageSize
     * @param buyList
     * @return
     */
    @RequestMapping("/purchase-page-list")
    public Result storeListPage(@RequestParam int currentPage, @RequestParam int pageSize, @RequestBody BuyList buyList){
        PageHelper.startPage(currentPage, pageSize);
        PageInfo<BuyList> pageInfo = new PageInfo<>(buyListService.findpurchaseList(buyList));
        return Result.success(pageInfo);
    }

    /**
     * 更新采购单
     * @param buyList
     * @return
     */

    @RequestMapping("/purchase-update")
    public Result purchaseUpdate(@RequestBody BuyList buyList){
        buyListService.purchaseUpdate(buyList);
        return Result.success();
    }

    /**
     * 删除采购单byid
     * @param buyId
     * @return
     */
    @RequestMapping("/deletePurchase")
    public Result deletePurchase(@RequestParam Integer buyId){
        buyListService.removeById(buyId);
        return Result.success();
    }
    @RequestMapping("/in-warehouse-record-add")
    public Result inWarehouseRecordAdd(@RequestBody BuyList buyList){

        int i=buyListService.saveInStore(buyList);
        if(i==1)
        return Result.success();
        else return Result.error();
    }


}
