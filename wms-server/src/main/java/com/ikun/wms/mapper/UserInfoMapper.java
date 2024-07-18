package com.ikun.wms.mapper;

import com.ikun.wms.pojo.entity.User;

/**
* @author yiwan
* @description 针对表【user_info(用户表)】的数据库操作Mapper
* @createDate 2024-07-18 11:22:49
* @Entity com.ikun.wms.pojo.entity.UserInfo
*/
public interface UserInfoMapper {

    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User getUserByName(String userName);
}
