package com.ikun.wms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ikun.wms.pojo.entity.BuyList;
import com.ikun.wms.pojo.entity.InStore;
import com.ikun.wms.pojo.vo.BuyListVo;
import com.ikun.wms.pojo.entity.User;
import com.ikun.wms.service.BuyListService;
import com.ikun.wms.mapper.BuyListMapper;
import com.ikun.wms.service.InStoreService;
import com.ikun.wms.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author yiwan
* @description 针对表【buy_list(采购单)】的数据库操作Service实现
* @createDate 2024-07-18 16:23:43
*/
@Service
public class BuyListServiceImpl extends ServiceImpl<BuyListMapper, BuyList>
    implements BuyListService{

    @Autowired
    private BuyListMapper buyListMapper;
    @Autowired
    private InStoreService inStoreService;
    @Override
    public int purchaseAdd(BuyList buyList) {
        return buyListMapper.purchaseAdd(buyList);
    }

    @Override
    public List<BuyListVo> findpurchaseList(BuyListVo buyListVo) {
        return buyListMapper.findpurchaseList(buyListVo);
    }

    @Override
    public int purchaseUpdate(BuyList buyList) {
        return buyListMapper.purchaseUpdate(buyList);
    }

    @Override
    public int saveInStore(BuyList buyList) {

        User user =(User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        InStore inStore=new InStore();
        inStore.setStoreId(buyList.getStoreId());
        inStore.setProductId(buyList.getProductId());
        inStore.setInNum(buyList.getFactBuyNum());
        inStore.setCreateBy(user.getUserId());
        boolean i = inStoreService.save(inStore);
        if(i){
            //根据id将采购单状态改为已入库
            int j = buyListMapper.updateIsInById(buyList.getBuyId());
            if(j>0){//成功
                return 1;
            }
            //失败
            return 0;
        }
        //失败
       return 0;
    }


}




