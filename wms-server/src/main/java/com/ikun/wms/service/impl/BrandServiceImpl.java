package com.ikun.wms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ikun.wms.pojo.entity.Brand;
import com.ikun.wms.service.BrandService;
import com.ikun.wms.mapper.BrandMapper;
import org.springframework.stereotype.Service;

/**
* @author yiwan
* @description 针对表【brand(品牌)】的数据库操作Service实现
* @createDate 2024-07-18 16:23:43
*/
@Service
public class BrandServiceImpl extends ServiceImpl<BrandMapper, Brand>
    implements BrandService{

}




