package com.ikun.wms.mapper;

import com.ikun.wms.pojo.entity.OutStore;

/**
* @author yiwan
* @description 针对表【out_store(出库单)】的数据库操作Mapper
* @createDate 2024-07-18 11:22:48
* @Entity com.ikun.wms.pojo.entity.OutStore
*/
public interface OutStoreMapper {

    int deleteByPrimaryKey(Long id);

    int insert(OutStore record);

    int insertSelective(OutStore record);

    OutStore selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(OutStore record);

    int updateByPrimaryKey(OutStore record);

}
