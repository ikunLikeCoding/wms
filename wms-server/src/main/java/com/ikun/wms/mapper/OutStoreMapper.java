package com.ikun.wms.mapper;

import com.ikun.wms.pojo.entity.OutStore;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ikun.wms.pojo.query.OutStoreQuery;

import java.util.List;

/**
* @author yiwan
* @description 针对表【out_store(出库单)】的数据库操作Mapper
* @createDate 2024-07-18 16:23:43
* @Entity com.ikun.wms.pojo.entity.OutStore
*/
public interface OutStoreMapper extends BaseMapper<OutStore> {

    List<OutStore> findOutStoreByPageAndCondition(OutStoreQuery outStoreQuery);
}




