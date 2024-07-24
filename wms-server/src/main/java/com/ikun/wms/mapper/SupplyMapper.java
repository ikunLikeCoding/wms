package com.ikun.wms.mapper;

import com.ikun.wms.pojo.entity.Supply;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
* @author yiwan
* @description 针对表【supply(供货商)】的数据库操作Mapper
* @createDate 2024-07-18 16:23:43
* @Entity com.ikun.wms.pojo.entity.Supply
*/
public interface SupplyMapper extends BaseMapper<Supply> {
    //查询所有供应商的方法
    public List<Supply> findAllSupply();
}




