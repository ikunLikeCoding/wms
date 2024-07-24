package com.ikun.wms.service;

import com.ikun.wms.pojo.entity.BuyList;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ikun.wms.pojo.vo.BuyListVo;
import com.ikun.wms.utils.Result;

import java.util.List;

/**
* @author yiwan
* @description 针对表【buy_list(采购单)】的数据库操作Service
* @createDate 2024-07-18 16:23:43
*/
public interface BuyListService extends IService<BuyList> {
    public int purchaseAdd(BuyList buyList);

    public List<BuyListVo> findpurchaseList(BuyListVo buyListVo);

    public int purchaseUpdate(BuyList buyList);

    public int saveInStore(BuyList buyList,int userId);
}
