package com.ikun.wms.mapper;

import com.ikun.wms.pojo.dto.ProductTypeTreeDTO;
import com.ikun.wms.pojo.entity.ProductType;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
* @author yiwan
* @description 针对表【product_type(商品分类表)】的数据库操作Mapper
* @createDate 2024-07-18 16:23:43
* @Entity com.ikun.wms.pojo.entity.ProductType
*/
public interface ProductTypeMapper extends BaseMapper<ProductType> {

    List<ProductTypeTreeDTO> getProductTypeTree();
     List<ProductType> findAllProductType();

    //根据分类编码查询商品分类的方法
     ProductType findTypeByCode(String typeCode);

    //添加商品分类的方法
     int insertProductType(ProductType productType);

    //根据分类id删除分类及其所有子级分类的方法
     int deleteProductType(Integer typeId);

    //根据分类id修改分类的方法
     int updateTypeById(ProductType productType);
}




