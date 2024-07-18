package com.ikun.wms.mapper;

import com.ikun.wms.pojo.entity.BuyList;

/**
* @author yiwan
* @description 针对表【buy_list(采购单)】的数据库操作Mapper
* @createDate 2024-07-18 11:22:48
* @Entity com.ikun.wms.pojo.entity.BuyList
*/
public interface BuyListMapper {

    int deleteByPrimaryKey(Long id);

    int insert(BuyList record);

    int insertSelective(BuyList record);

    BuyList selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(BuyList record);

    int updateByPrimaryKey(BuyList record);

}
