package com.ikun.wms.mapper;

import com.ikun.wms.pojo.entity.InStore;

/**
* @author yiwan
* @description 针对表【in_store(入库单)】的数据库操作Mapper
* @createDate 2024-07-18 11:22:48
* @Entity com.ikun.wms.pojo.entity.InStore
*/
public interface InStoreMapper {

    int deleteByPrimaryKey(Long id);

    int insert(InStore record);

    int insertSelective(InStore record);

    InStore selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(InStore record);

    int updateByPrimaryKey(InStore record);

}
