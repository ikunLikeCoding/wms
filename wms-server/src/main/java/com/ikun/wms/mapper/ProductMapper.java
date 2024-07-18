package com.ikun.wms.mapper;

import com.ikun.wms.pojo.entity.Product;

/**
* @author yiwan
* @description 针对表【product(商品表)】的数据库操作Mapper
* @createDate 2024-07-18 11:22:49
* @Entity com.ikun.wms.pojo.entity.Product
*/
public interface ProductMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Product record);

    int insertSelective(Product record);

    Product selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);

}
