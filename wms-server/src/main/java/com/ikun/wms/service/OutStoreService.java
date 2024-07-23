package com.ikun.wms.service;

import com.github.pagehelper.PageInfo;
import com.ikun.wms.pojo.entity.OutStore;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ikun.wms.pojo.query.OutStoreQuery;

/**
* @author yiwan
* @description 针对表【out_store(出库单)】的数据库操作Service
* @createDate 2024-07-18 16:23:43
*/
public interface OutStoreService extends IService<OutStore> {

    PageInfo<OutStore> findOutStoreByPageAndCondition(OutStoreQuery outStoreQuery);
}
