package com.ikun.wms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ikun.wms.pojo.entity.Place;
import com.ikun.wms.service.PlaceService;
import com.ikun.wms.mapper.PlaceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author yiwan
* @description 针对表【place(产地)】的数据库操作Service实现
* @createDate 2024-07-18 16:23:43
*/
@Service
public class PlaceServiceImpl extends ServiceImpl<PlaceMapper, Place>
    implements PlaceService{
    //注入PlaceMapper
    @Autowired
    private PlaceMapper placeMapper;

    /*
      查询所有产地的业务方法
     */
    //对查询到的所有产地进行缓存,缓存到redis的键为all:place
    @Cacheable(key = "'all:place'")
    @Override
    public List<Place> queryAllPlace() {
        //查询所有产地
        return placeMapper.findAllPlace();
    }
}




