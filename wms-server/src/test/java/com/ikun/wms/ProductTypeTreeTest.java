package com.ikun.wms;

import com.ikun.wms.pojo.dto.ProductTypeTreeDTO;
import com.ikun.wms.service.ProductTypeService;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @Author: yiwang
 * @Date: 2024/7/23
 */

@SpringBootTest
public class ProductTypeTreeTest {
    @Resource
    private ProductTypeService productTypeService;


    @Test
    public void testGetTree(){

//        List<ProductTypeTreeDTO> productTree = productTypeService.findProductTree();
//        productTree.forEach(productTypeTreeDTO -> {
//            System.out.println(productTypeTreeDTO.getTypeName());
//            System.out.println("-----------------------------------");
//            productTypeTreeDTO.getChildren().forEach(productTypeTreeDTO1 -> {
//                System.out.println(productTypeTreeDTO1.getTypeName());
//            });
//            System.out.println("******************************************");
//        });
    }
}
