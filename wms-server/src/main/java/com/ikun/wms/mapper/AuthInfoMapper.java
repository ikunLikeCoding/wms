package com.ikun.wms.mapper;

import com.ikun.wms.pojo.entity.AuthInfo;

/**
* @author yiwan
* @description 针对表【auth_info(权限表)】的数据库操作Mapper
* @createDate 2024-07-18 11:22:48
* @Entity com.ikun.wms.pojo.entity.AuthInfo
*/
public interface AuthInfoMapper {

    int deleteByPrimaryKey(Long id);

    int insert(AuthInfo record);

    int insertSelective(AuthInfo record);

    AuthInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AuthInfo record);

    int updateByPrimaryKey(AuthInfo record);

}
