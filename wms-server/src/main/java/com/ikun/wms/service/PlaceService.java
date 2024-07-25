package com.ikun.wms.service;

import com.ikun.wms.pojo.entity.Place;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author yiwan
* @description 针对表【place(产地)】的数据库操作Service
* @createDate 2024-07-18 16:23:43
*/
public interface PlaceService extends IService<Place> {
    //查询所有产地的业务方法
     List<Place> queryAllPlace();
}
