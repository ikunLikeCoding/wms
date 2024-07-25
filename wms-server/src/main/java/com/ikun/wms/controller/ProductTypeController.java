package com.ikun.wms.controller;

/**
 * @Author: yiwang
 * @Date: 2024/7/22
 */

import com.ikun.wms.pojo.dto.ProductTypeTreeDTO;
import com.ikun.wms.pojo.entity.ProductType;
import com.ikun.wms.service.ProductTypeService;
import com.ikun.wms.utils.Result;
import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/***
 * 商品类型管理
 */
@RestController
@RequestMapping("/productCategory")
public class ProductTypeController {

    private static final Logger log = LoggerFactory.getLogger(ProductTypeController.class);
    @Resource
    private ProductTypeService productTypeService;
    @GetMapping("/product-category-tree")
    public Result<List<ProductTypeTreeDTO>> productCategoryTree() {
        log.info("获取商品类型树");
        List<ProductTypeTreeDTO> productTree = productTypeService.findProductTree();

        return Result.success(productTree);
    }


    @GetMapping("/type-code-verify")
    public Result typeCodeVerify(String typeCode) {

        log.info("验证商品类型编码是否可用{}",typeCode);
        boolean flag = productTypeService.typeCodeExist(typeCode);
        log.info("flag{}",flag);
        if (flag) {
            return Result.error("商品类型编码已存在");
        }
        return Result.success();
    }

    @PostMapping("/type-add")
    public Result typeAdd(@RequestBody ProductType productType) {
        log.info("新增商品类型{}",productType);
        boolean save = productTypeService.save(productType);
        if (!save) {
            return Result.error("新增商品类型失败");
        }

        return Result.success();
    }

    @PutMapping("/type-update")
    public Result typeUpdate(@RequestBody ProductType productType) {
        log.info("修改商品类型{}",productType);
        boolean b = productTypeService.updateById(productType);
        if (!b) {
            return Result.error("修改商品类型失败");
        }
        return Result.success();
    }

    @DeleteMapping("/type-delete/{typeId}")
    public Result typeDelete(@PathVariable("typeId") Integer typeId) {
        log.info("删除商品类型{}",typeId);

        boolean b = productTypeService.removeById(typeId);
        if (!b) {
            return Result.error("删除商品类型失败");
        }

        return Result.success();
    }
}
