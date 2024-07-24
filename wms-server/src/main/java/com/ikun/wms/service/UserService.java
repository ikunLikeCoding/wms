package com.ikun.wms.service;

import com.github.pagehelper.PageInfo;
import com.ikun.wms.pojo.dto.AuthTree;
import com.ikun.wms.pojo.dto.UserDTO;
import com.ikun.wms.pojo.entity.AuthInfo;
import com.ikun.wms.pojo.entity.Role;
import com.ikun.wms.pojo.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ikun.wms.pojo.query.UserQuery;
import com.ikun.wms.pojo.vo.UserVO;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

/**
* @author yiwan
* @description 针对表【user_info(用户表)】的数据库操作Service
* @createDate 2024-07-18 16:23:43
*/
public interface UserService extends IService<User>, UserDetailsService {
    User findByUserName(String username);


    PageInfo<UserVO> findUserByPageAndCondition(UserQuery userQuery);

    int updateUserState(User user);

    List<Role> getRoleList(Integer id);

    int roleAssign(UserDTO user);
}
