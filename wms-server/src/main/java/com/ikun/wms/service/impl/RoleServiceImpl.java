package com.ikun.wms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ikun.wms.pojo.entity.Role;
import com.ikun.wms.service.RoleService;
import com.ikun.wms.mapper.RoleMapper;
import org.springframework.stereotype.Service;

/**
* @author yiwan
* @description 针对表【role(角色表)】的数据库操作Service实现
* @createDate 2024-07-18 16:23:43
*/
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role>
    implements RoleService{

}



