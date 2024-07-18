package com.ikun.wms.mapper;

import com.ikun.wms.pojo.entity.Supply;

/**
* @author yiwan
* @description 针对表【supply(供货商)】的数据库操作Mapper
* @createDate 2024-07-18 11:22:49
* @Entity com.ikun.wms.pojo.entity.Supply
*/
public interface SupplyMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Supply record);

    int insertSelective(Supply record);

    Supply selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Supply record);

    int updateByPrimaryKey(Supply record);

}
