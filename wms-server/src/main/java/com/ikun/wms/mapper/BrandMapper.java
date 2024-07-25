package com.ikun.wms.mapper;

import com.ikun.wms.pojo.entity.Brand;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
* @author yiwan
* @description 针对表【brand(品牌)】的数据库操作Mapper
* @createDate 2024-07-18 16:23:43
* @Entity com.ikun.wms.pojo.entity.Brand
*/
public interface BrandMapper extends BaseMapper<Brand> {
    //查询所有品牌的方法
     List<Brand> findAllBrand();
}




