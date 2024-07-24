package com.ikun.wms.mapper;

import com.ikun.wms.pojo.entity.Place;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
* @author yiwan
* @description 针对表【place(产地)】的数据库操作Mapper
* @createDate 2024-07-18 16:23:43
* @Entity com.ikun.wms.pojo.entity.Place
*/
public interface PlaceMapper extends BaseMapper<Place> {
    //查询所有产地
    public List<Place> findAllPlace();
}




