package com.ikun.wms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ikun.wms.mapper.ProductMapper;
import com.ikun.wms.pojo.dto.ProductTypeTreeDTO;
import com.ikun.wms.pojo.entity.ProductType;
import com.ikun.wms.service.ProductTypeService;
import com.ikun.wms.mapper.ProductTypeMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

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
    private ProductTypeMapper typeMapper;
    @Override
    public List<ProductTypeTreeDTO> findProductTree() {




        return typeMapper.getProductTypeTree();
    }

    @Override
    public boolean typeCodeExist(String typeCode) {
        QueryWrapper<ProductType> queryWrapper = new QueryWrapper<>();

        queryWrapper.eq("type_code",typeCode);
        if (typeMapper.selectCount(queryWrapper) > 0) {
            return true;
        }
        return false;
    }

}




