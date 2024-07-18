package com.ikun.wms.mapper;

import com.ikun.wms.pojo.entity.RoleAuth;

/**
* @author yiwan
* @description 针对表【role_auth(角色权限表)】的数据库操作Mapper
* @createDate 2024-07-18 11:22:49
* @Entity com.ikun.wms.pojo.entity.RoleAuth
*/
public interface RoleAuthMapper {

    int deleteByPrimaryKey(Long id);

    int insert(RoleAuth record);

    int insertSelective(RoleAuth record);

    RoleAuth selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(RoleAuth record);

    int updateByPrimaryKey(RoleAuth record);

}
