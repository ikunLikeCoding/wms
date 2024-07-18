package com.ikun.wms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ikun.wms.pojo.entity.ProductType;
import com.ikun.wms.service.ProductTypeService;
import com.ikun.wms.mapper.ProductTypeMapper;
import org.springframework.stereotype.Service;

/**
* @author yiwan
* @description 针对表【product_type(商品分类表)】的数据库操作Service实现
* @createDate 2024-07-18 16:23:43
*/
@Service
public class ProductTypeServiceImpl extends ServiceImpl<ProductTypeMapper, ProductType>
    implements ProductTypeService{

}




