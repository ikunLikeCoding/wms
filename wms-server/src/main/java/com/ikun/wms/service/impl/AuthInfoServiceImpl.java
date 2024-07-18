package com.ikun.wms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ikun.wms.pojo.entity.AuthInfo;
import com.ikun.wms.service.AuthInfoService;
import com.ikun.wms.mapper.AuthInfoMapper;
import org.springframework.stereotype.Service;

/**
* @author yiwan
* @description 针对表【auth_info(权限表)】的数据库操作Service实现
* @createDate 2024-07-18 16:23:43
*/
@Service
public class AuthInfoServiceImpl extends ServiceImpl<AuthInfoMapper, AuthInfo>
    implements AuthInfoService{

}




