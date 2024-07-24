package com.ikun.wms.controller;

/**
 * @Author: yiwang
 * @Date: 2024/7/22
 */

import com.ikun.wms.pojo.entity.ProductType;
import com.ikun.wms.service.ProductTypeService;
import com.ikun.wms.utils.Result;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;


/***
 * 商品类型管理
 */
@RestController
@RequestMapping("/productCategory")
public class ProductTypeController {
    @Resource
    private ProductTypeService productTypeService;
    @GetMapping("/product-category-tree")
    public Result productCategoryTree() {

        return Result.success(productTypeService.allProductTypeTree());
    }

    /**
     * 校验分类编码是否已存在的url接口/productCategory/verify-type-code
     */
    @RequestMapping("/verify-type-code")
    public Result checkTypeCode(String typeCode){
        //执行业务
        Result result = productTypeService.queryTypeByCode(typeCode);
        //响应
        return result;
    }

    @RequestMapping("/type-add")
    public Result addProductType(@RequestBody ProductType productType){
        //执行业务
        Result result = productTypeService.saveProductType(productType);
        //响应
        return result;
    }

    @RequestMapping("/type-delete/{typeId}")
    public Result deleteType(@PathVariable Integer typeId){
        //执行业务
        Result result = productTypeService.removeProductType(typeId);
        //响应
        return result;
    }


    @RequestMapping("/type-update")
    public Result updateType(@RequestBody ProductType productType){
        //执行业务
        Result result = productTypeService.updateProductType(productType);
        //响应
        return result;
    }
}



