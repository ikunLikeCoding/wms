package com.ikun.wms.mapper;

import com.ikun.wms.pojo.entity.Product;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ikun.wms.utils.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author yiwan
* @description 针对表【product(商品表)】的数据库操作Mapper
* @createDate 2024-07-18 16:23:43
* @Entity com.ikun.wms.pojo.entity.Product
*/
public interface ProductMapper extends BaseMapper<Product> {
    //查询商品总行数的方法
   public int selectProductCount(Product product);

    //分页查询商品的方法
    public List<Product> selectProductPage(@Param("page") Page page, @Param("product") Product product);

    //添加商品的方法
    public int insertProduct(Product product);

    //根据商品id修改商品的上下架状态
    public int updateStateById(Product product);

    //根据商品id删除商品的方法
    public int deleteProductById(Integer productId);

    //根据商品id修改商品的方法
    public int updateProductById(Product product);

    //根据商品id增加商品库存的方法
    public int addInventById(Integer productId, Integer invent);

    //根据商品id查询商品的方法
    public Product selectProductById(Integer productId);


}




