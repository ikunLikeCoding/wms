package com.ikun.wms.mapper;

import com.ikun.wms.pojo.entity.Unit;

/**
* @author yiwan
* @description 针对表【unit(规格单位表)】的数据库操作Mapper
* @createDate 2024-07-18 11:22:49
* @Entity com.ikun.wms.pojo.entity.Unit
*/
public interface UnitMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Unit record);

    int insertSelective(Unit record);

    Unit selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Unit record);

    int updateByPrimaryKey(Unit record);

}
