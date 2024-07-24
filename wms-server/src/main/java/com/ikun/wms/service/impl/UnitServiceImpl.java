package com.ikun.wms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ikun.wms.pojo.entity.Unit;
import com.ikun.wms.service.UnitService;
import com.ikun.wms.mapper.UnitMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author yiwan
* @description 针对表【unit(规格单位表)】的数据库操作Service实现
* @createDate 2024-07-18 16:23:43
*/
@Service
public class UnitServiceImpl extends ServiceImpl<UnitMapper, Unit>
    implements UnitService{
    //注入UnitMapper
    @Autowired
    private UnitMapper unitMapper;

    /*
      查询所有单位的业务方法
     */
    //对查询到的所有单位进行缓存,缓存到redis的键为all:unit
    @Cacheable(key = "'all:unit'")
    @Override
    public List<Unit> queryAllUnit() {
        //查询所有单位
        return unitMapper.findAllUnit();
    }
}




