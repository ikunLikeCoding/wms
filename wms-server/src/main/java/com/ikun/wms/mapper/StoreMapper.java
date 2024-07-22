package com.ikun.wms.mapper;

import com.github.pagehelper.PageInfo;
import com.ikun.wms.pojo.entity.Store;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ikun.wms.pojo.query.InStoreQuery;
import com.ikun.wms.pojo.vo.InStoreVO;

import java.util.List;

/**
* @author yiwan
* @description 针对表【store(仓库表)】的数据库操作Mapper
* @createDate 2024-07-18 16:23:43
* @Entity com.ikun.wms.pojo.entity.Store
*/
public interface StoreMapper extends BaseMapper<Store> {

    List<InStoreVO> findStoreByPageAndCondition(InStoreQuery inStoreQuery);
}




