package com.ikun.wms.mapper;

import com.ikun.wms.pojo.entity.BuyList;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ikun.wms.pojo.entity.InStore;
import com.ikun.wms.pojo.vo.BuyListVo;
import com.ikun.wms.utils.Result;

import java.util.List;

/**
* @author yiwan
* @description 针对表【buy_list(采购单)】的数据库操作Mapper
* @createDate 2024-07-18 16:23:43
* @Entity com.ikun.wms.pojo.entity.BuyList
*/
public interface BuyListMapper extends BaseMapper<BuyList> {

    public int purchaseAdd(BuyList buyList);

    public List<BuyListVo> findpurchaseList(BuyListVo buyListVo);

    public int purchaseUpdate(BuyList buyList);

    public int updateIsInById(Integer buyId);
}




