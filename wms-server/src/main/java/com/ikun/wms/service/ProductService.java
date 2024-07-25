package com.ikun.wms.service;

import com.ikun.wms.pojo.entity.Product;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ikun.wms.utils.Page;
import com.ikun.wms.utils.Result;

/**
* @author yiwan
* @description 针对表【product(商品表)】的数据库操作Service
* @createDate 2024-07-18 16:23:43
*/
public interface ProductService extends IService<Product> {
    //分页查询商品的业务方法
    public Page queryProductPage(Page page, Product product);
    //添加商品的业务方法
    public Result saveProduct(Product product);

    //修改商品上下架状态的业务方法
    public Result updateProductState(Product product);

    //删除商品的业务方法
    public Result deleteProduct(Integer productId);

    //修改商品的业务方法
    public Result updateProduct(Product product);
}

