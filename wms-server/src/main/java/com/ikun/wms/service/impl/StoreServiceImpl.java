package com.ikun.wms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ikun.wms.pojo.entity.Store;
import com.ikun.wms.service.StoreService;
import com.ikun.wms.mapper.StoreMapper;
import org.springframework.stereotype.Service;

/**
* @author yiwan
* @description 针对表【store(仓库表)】的数据库操作Service实现
* @createDate 2024-07-18 16:23:43
*/
@Service
public class StoreServiceImpl extends ServiceImpl<StoreMapper, Store>
    implements StoreService{

}




