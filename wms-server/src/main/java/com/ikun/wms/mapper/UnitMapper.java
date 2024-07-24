package com.ikun.wms.mapper;

import com.ikun.wms.pojo.entity.Unit;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
* @author yiwan
* @description 针对表【unit(规格单位表)】的数据库操作Mapper
* @createDate 2024-07-18 16:23:43
* @Entity com.ikun.wms.pojo.entity.Unit
*/
public interface UnitMapper extends BaseMapper<Unit> {
    //查询所有单位的方法
    public List<Unit> findAllUnit();
}



