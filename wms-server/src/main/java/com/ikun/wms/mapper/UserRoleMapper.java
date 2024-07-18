package com.ikun.wms.mapper;

import com.ikun.wms.pojo.entity.UserRole;

/**
* @author yiwan
* @description 针对表【user_role(用户角色表)】的数据库操作Mapper
* @createDate 2024-07-18 11:22:49
* @Entity com.ikun.wms.pojo.entity.UserRole
*/
public interface UserRoleMapper {

    int deleteByPrimaryKey(Long id);

    int insert(UserRole record);

    int insertSelective(UserRole record);

    UserRole selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserRole record);

    int updateByPrimaryKey(UserRole record);

}
