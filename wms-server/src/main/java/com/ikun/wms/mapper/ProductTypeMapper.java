package com.ikun.wms.mapper;

import com.ikun.wms.pojo.entity.ProductType;

/**
* @author yiwan
* @description 针对表【product_type(商品分类表)】的数据库操作Mapper
* @createDate 2024-07-18 11:22:49
* @Entity com.ikun.wms.pojo.entity.ProductType
*/
public interface ProductTypeMapper {

    int deleteByPrimaryKey(Long id);

    int insert(ProductType record);

    int insertSelective(ProductType record);

    ProductType selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ProductType record);

    int updateByPrimaryKey(ProductType record);

}
