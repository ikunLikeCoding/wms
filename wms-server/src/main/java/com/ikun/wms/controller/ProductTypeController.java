package com.ikun.wms.controller;

/**
 * @Author: yiwang
 * @Date: 2024/7/22
 */

import com.ikun.wms.utils.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/***
 * 商品类型管理
 */
@RestController
@RequestMapping("/productCategory")
public class ProductTypeController {

    @GetMapping("/product-category-tree")
    public Result productCategoryTree() {

        return Result.success();
    }
}
