package com.ikun.wms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ikun.wms.pojo.entity.Store;
import com.ikun.wms.pojo.query.InStoreQuery;
import com.ikun.wms.pojo.query.StoreQuery;
import com.ikun.wms.pojo.vo.InStoreVO;
import com.ikun.wms.service.StoreService;
import com.ikun.wms.mapper.StoreMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;


/**
* @author yiwan
* @description 针对表【store(仓库表)】的数据库操作Service实现
* @createDate 2024-07-18 16:23:43
*/
@Service
public class StoreServiceImpl extends ServiceImpl<StoreMapper, Store>
    implements StoreService{

    @Resource
    private StoreMapper storeMapper;
    @Override
    public PageInfo<InStoreVO> findStoreByPageAndCondition(InStoreQuery inStoreQuery) {
        PageHelper.startPage(inStoreQuery.getCurrentPage(), inStoreQuery.getPageSize());
        List<InStoreVO> storeByPageAndCondition = storeMapper.findStoreByPageAndCondition(inStoreQuery);
        return new PageInfo<>(storeByPageAndCondition);
    }

    @Override
    public List<Store> findPageStore(StoreQuery storeQuery) {
        return storeMapper.findPageStore(storeQuery);
    }

    @Override
    public Store findStoreByNum(String storeNum) {
        return storeMapper.findStoreByNum(storeNum);
    }
}




