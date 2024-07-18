package com.ikun.wms.mapper;

import com.ikun.wms.pojo.entity.Brand;

/**
* @author yiwan
* @description 针对表【brand(品牌)】的数据库操作Mapper
* @createDate 2024-07-18 11:22:48
* @Entity com.ikun.wms.pojo.entity.Brand
*/
public interface BrandMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Brand record);

    int insertSelective(Brand record);

    Brand selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Brand record);

    int updateByPrimaryKey(Brand record);

}
