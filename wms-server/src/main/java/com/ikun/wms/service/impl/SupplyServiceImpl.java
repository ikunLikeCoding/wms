package com.ikun.wms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ikun.wms.pojo.entity.Supply;
import com.ikun.wms.service.SupplyService;
import com.ikun.wms.mapper.SupplyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author yiwan
* @description 针对表【supply(供货商)】的数据库操作Service实现
* @createDate 2024-07-18 16:23:43
*/
@Service
public class SupplyServiceImpl extends ServiceImpl<SupplyMapper, Supply>
    implements SupplyService{
    //注入SupplyMapper
    @Autowired
    private SupplyMapper supplyMapper;

    /*
      查询所有供应商的业务方法
     */
    //对查询到的所有供应商进行缓存,缓存到redis的键为all:supply
    @Cacheable(key = "'all:supply'")
    @Override
    public List<Supply> queryAllSupply() {
        //查询所有供应商
        return supplyMapper.findAllSupply();
    }
}




