package com.ikun.wms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ikun.wms.pojo.entity.UserRole;
import com.ikun.wms.service.UserRoleService;
import com.ikun.wms.mapper.UserRoleMapper;
import org.springframework.stereotype.Service;

/**
* @author yiwan
* @description 针对表【user_role(用户角色表)】的数据库操作Service实现
* @createDate 2024-07-18 16:23:43
*/
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole>
    implements UserRoleService{

}




