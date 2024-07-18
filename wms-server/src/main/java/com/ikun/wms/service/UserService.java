package com.ikun.wms.service;

import com.ikun.wms.pojo.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
* @author yiwan
* @description 针对表【user_info(用户表)】的数据库操作Service
* @createDate 2024-07-18 16:23:43
*/
public interface UserService extends IService<User>, UserDetailsService {
    User findByUserName(String username);
}
