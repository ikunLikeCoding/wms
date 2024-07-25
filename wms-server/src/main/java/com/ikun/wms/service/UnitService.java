package com.ikun.wms.service;

import com.ikun.wms.pojo.entity.Unit;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author yiwan
* @description 针对表【unit(规格单位表)】的数据库操作Service
* @createDate 2024-07-18 16:23:43
*/
public interface UnitService extends IService<Unit> {
    //查询所有单位的业务方法
     List<Unit> queryAllUnit();
}
