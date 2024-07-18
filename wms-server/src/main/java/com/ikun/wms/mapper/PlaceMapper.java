package com.ikun.wms.mapper;

import com.ikun.wms.pojo.entity.Place;

/**
* @author yiwan
* @description 针对表【place(产地)】的数据库操作Mapper
* @createDate 2024-07-18 11:22:49
* @Entity com.ikun.wms.pojo.entity.Place
*/
public interface PlaceMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Place record);

    int insertSelective(Place record);

    Place selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Place record);

    int updateByPrimaryKey(Place record);

}
