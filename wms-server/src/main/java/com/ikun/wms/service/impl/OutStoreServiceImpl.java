package com.ikun.wms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ikun.wms.pojo.entity.OutStore;
import com.ikun.wms.pojo.query.OutStoreQuery;
import com.ikun.wms.service.OutStoreService;
import com.ikun.wms.mapper.OutStoreMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author yiwan
* @description 针对表【out_store(出库单)】的数据库操作Service实现
* @createDate 2024-07-18 16:23:43
*/
@Service
public class OutStoreServiceImpl extends ServiceImpl<OutStoreMapper, OutStore>
    implements OutStoreService{

    @Resource
    private OutStoreMapper outStoreMapper;
    @Override
    public PageInfo<OutStore> findOutStoreByPageAndCondition(OutStoreQuery outStoreQuery) {
        PageHelper.startPage(outStoreQuery.getCurrentPage(), outStoreQuery.getPageSize());
        List<OutStore> list = outStoreMapper.findOutStoreByPageAndCondition(outStoreQuery);
        return new PageInfo<>(list);
    }
}




