package com.ikun.wms.service;

import com.ikun.wms.pojo.dto.AuthTree;
import com.ikun.wms.pojo.entity.AuthInfo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author yiwan
* @description 针对表【auth_info(权限表)】的数据库操作Service
* @createDate 2024-07-18 16:23:43
*/
public interface AuthInfoService extends IService<AuthInfo> {
    List<AuthTree> getAuthTreeByUserId();
}
