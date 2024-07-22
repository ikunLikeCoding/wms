package com.ikun.wms.service;

import com.github.pagehelper.PageInfo;
import com.ikun.wms.pojo.entity.Store;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ikun.wms.pojo.query.InStoreQuery;
import com.ikun.wms.pojo.vo.InStoreVO;

/**
* @author yiwan
* @description 针对表【store(仓库表)】的数据库操作Service
* @createDate 2024-07-18 16:23:43
*/
public interface StoreService extends IService<Store> {


    PageInfo<InStoreVO> findStoreByPageAndCondition(InStoreQuery inStoreQuery);
}
