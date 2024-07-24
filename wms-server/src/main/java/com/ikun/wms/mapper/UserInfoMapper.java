package com.ikun.wms.mapper;

import com.ikun.wms.pojo.entity.Role;
import com.ikun.wms.pojo.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ikun.wms.pojo.query.UserQuery;
import com.ikun.wms.pojo.vo.UserVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author yiwan
* @description 针对表【user_info(用户表)】的数据库操作Mapper
* @createDate 2024-07-18 16:23:43
* @Entity com.ikun.wms.pojo.entity.UserInfo
*/

public interface UserInfoMapper extends BaseMapper<User> {

    List<UserVO> findUserByPageAndCondition(UserQuery userQuery);

    List<Role> getRoleList(Integer id);
}




