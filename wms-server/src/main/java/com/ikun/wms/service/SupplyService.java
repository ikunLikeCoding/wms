package com.ikun.wms.service;

import com.ikun.wms.pojo.entity.Supply;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author yiwan
* @description 针对表【supply(供货商)】的数据库操作Service
* @createDate 2024-07-18 16:23:43
*/
public interface SupplyService extends IService<Supply> {
    //查询所有供应商的业务方法
    public List<Supply> queryAllSupply();
}
