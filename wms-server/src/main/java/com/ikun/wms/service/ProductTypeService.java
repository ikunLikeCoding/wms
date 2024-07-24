package com.ikun.wms.service;

import com.ikun.wms.pojo.entity.ProductType;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ikun.wms.utils.Result;

import java.util.List;

/**
* @author yiwan
* @description 针对表【product_type(商品分类表)】的数据库操作Service
* @createDate 2024-07-18 16:23:43
*/
public interface ProductTypeService extends IService<ProductType> {
    //查询所有商品分类树的业务方法
    public List<ProductType> allProductTypeTree();

    //校验分类编码是否已存在的业务方法
    public Result queryTypeByCode(String typeCode);

    //添加商品分类的业务方法
    public Result saveProductType(ProductType productType);

    //删除商品分类的业务方法
    public Result removeProductType(Integer typeId);

    //修改商品分类的业务方法
    public Result updateProductType(ProductType productType);


}
