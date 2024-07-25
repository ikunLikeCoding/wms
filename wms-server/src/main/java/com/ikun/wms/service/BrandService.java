package com.ikun.wms.service;

import com.ikun.wms.pojo.entity.Brand;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author yiwan
* @description 针对表【brand(品牌)】的数据库操作Service
* @createDate 2024-07-18 16:23:43
*/
public interface BrandService extends IService<Brand> {
    //查询所有品牌的业务方法
    public List<Brand> queryAllBrand();
}
