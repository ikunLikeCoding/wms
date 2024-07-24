package com.ikun.wms.mapper;

import com.ikun.wms.pojo.entity.AuthInfo;
import com.ikun.wms.pojo.entity.Role;
import com.ikun.wms.pojo.entity.UserRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
* @author yiwan
* @description 针对表【user_role(用户角色表)】的数据库操作Mapper
* @createDate 2024-07-18 16:23:43
* @Entity com.ikun.wms.pojo.entity.UserRole
*/
public interface UserRoleMapper extends BaseMapper<UserRole> {

    int removeByUserId(Integer userId);

    List<Role> getRoleListByUserId(Integer userId);

    List<AuthInfo> getPermissionListByRoleId(List<Role> roleList);
}




