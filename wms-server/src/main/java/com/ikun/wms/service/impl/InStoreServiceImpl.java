package com.ikun.wms.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ikun.wms.pojo.entity.InStore;
import com.ikun.wms.service.InStoreService;
import com.ikun.wms.mapper.InStoreMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
* @author yiwan
* @description 针对表【in_store(入库单)】的数据库操作Service实现
* @createDate 2024-07-18 16:23:43
*/
@Service
public class InStoreServiceImpl extends ServiceImpl<InStoreMapper, InStore>
    implements InStoreService{
    @Resource
    private InStoreMapper inStoreMapper;
    @Override
    public Integer confirmInStore(InStore inStore) {
        UpdateWrapper<InStore> inStoreUpdateWrapper = new UpdateWrapper<>();
        inStoreUpdateWrapper.set("is_in", "1");
        inStoreUpdateWrapper.eq("ins_id", inStore.getInsId());
        int update = inStoreMapper.update(inStore, inStoreUpdateWrapper);
        if (update > 0) {

            return  inStoreMapper.updateStoreNums(inStore);
        }
        return 0;
    }
}




