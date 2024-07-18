package com.ikun.wms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ikun.wms.pojo.entity.Product;
import com.ikun.wms.service.ProductService;
import com.ikun.wms.mapper.ProductMapper;
import org.springframework.stereotype.Service;

/**
* @author yiwan
* @description 针对表【product(商品表)】的数据库操作Service实现
* @createDate 2024-07-18 16:23:43
*/
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product>
    implements ProductService{

}




