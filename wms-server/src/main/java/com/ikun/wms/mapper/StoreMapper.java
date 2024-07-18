package com.ikun.wms.mapper;

import com.ikun.wms.pojo.entity.Store;

/**
* @author yiwan
* @description 针对表【store(仓库表)】的数据库操作Mapper
* @createDate 2024-07-18 11:22:49
* @Entity com.ikun.wms.pojo.entity.Store
*/
public interface StoreMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Store record);

    int insertSelective(Store record);

    Store selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Store record);

    int updateByPrimaryKey(Store record);

}
