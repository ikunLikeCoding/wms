package com.ikun.wms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ikun.wms.pojo.entity.ProductType;
import com.ikun.wms.service.ProductTypeService;
import com.ikun.wms.mapper.ProductTypeMapper;
import com.ikun.wms.utils.Result;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
* @author yiwan
* @description 针对表【product_type(商品分类表)】的数据库操作Service实现
* @createDate 2024-07-18 16:23:43
*/
@Service
public class ProductTypeServiceImpl extends ServiceImpl<ProductTypeMapper, ProductType>
    implements ProductTypeService{
    @Resource
    private ProductTypeMapper productTypeMapper;

    /*
      查询所有商品分类树的业务方法
     */
    //对查询到的所有商品分类树进行缓存,缓存到redis的键为all:typeTree
    @Cacheable(key = "'all:typeTree'")
    @Override
    public List<ProductType> allProductTypeTree() {
        //查询所有商品分类
        List<ProductType> allTypeList = productTypeMapper.findAllProductType();
        //将所有商品分类List<ProductType>转成商品分类树List<ProductType>
        List<ProductType> typeTreeList = allTypeToTypeTree(allTypeList, 0);
        //返回商品分类树List<ProductType>
        return typeTreeList;
    }

    //将查询到的所有商品分类List<ProductType>转成商品分类树List<ProductType>的算法
    private List<ProductType> allTypeToTypeTree(List<ProductType> allTypeList, Integer parentId){

        List<ProductType> typeList = new ArrayList<>();
        for (ProductType productType : allTypeList) {
            if(productType.getParentId().equals(parentId)){
                typeList.add(productType);
            }
        }

        for (ProductType productType : typeList) {
            List<ProductType> childTypeList = allTypeToTypeTree(allTypeList, productType.getTypeId());
            productType.setChildProductCategory(childTypeList);
        }

        return typeList;
    }

    //校验分类编码是否已存在的业务方法
    @Override
    public Result queryTypeByCode(String typeCode) {

        //根据分类编码查询商品分类
        ProductType productType = productTypeMapper.findTypeByCode(typeCode);

        return Result.success(productType==null);
    }

    /*
      添加商品分类的业务方法

      @CacheEvict(key = "'all:typeTree'")清除所有商品分类树的缓存;
     */
    @CacheEvict(key = "'all:typeTree'")
    @Override
    public Result saveProductType(ProductType productType) {
        //添加商品分类
        int i = productTypeMapper.insertProductType(productType);
        if(i>0){
            return Result.success("分类添加成功！");
        }
        return Result.error("分类添加失败！");
    }

    /*
      删除商品分类的业务方法

      @CacheEvict(key = "'all:typeTree'")清除所有商品分类树的缓存;
     */
    @CacheEvict(key = "'all:typeTree'")
    @Override
    public Result removeProductType(Integer typeId) {
        //根据分类id删除分类及其所有子级分类
        int i = productTypeMapper.deleteProductType(typeId);
        if(i>0){
            return Result.success("分类删除成功！");
        }
        return Result.error( "分类删除失败！");
    }

    /*
      修改商品分类的业务方法

      @CacheEvict(key = "'all:typeTree'")清除所有商品分类树的缓存;
     */
    @CacheEvict(key = "'all:typeTree'")
    @Override
    public Result updateProductType(ProductType productType) {
        //根据分类id修改分类
        int i = productTypeMapper.updateTypeById(productType);
        if(i>0){
            return Result.success("分类修改成功！");
        }
        return Result.error( "分类修改失败！");
    }
}






