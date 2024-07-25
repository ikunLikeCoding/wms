package com.ikun.wms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ikun.wms.pojo.entity.Brand;
import com.ikun.wms.service.BrandService;
import com.ikun.wms.mapper.BrandMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author yiwan
* @description 针对表【brand(品牌)】的数据库操作Service实现
* @createDate 2024-07-18 16:23:43
*/
@Service
public class BrandServiceImpl extends ServiceImpl<BrandMapper, Brand>
    implements BrandService{
    //注入BrandMapper
    @Autowired
    private BrandMapper brandMapper;

    /*
      查询所有品牌的业务方法
     */
    //对查询到的所有品牌进行缓存,缓存到redis的键为all:brand
    @Cacheable(key = "'all:brand'")
    @Override
    public List<Brand> queryAllBrand() {
        //查询所有品牌
        return brandMapper.findAllBrand();
    }
}




