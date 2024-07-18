package com.ikun.wms.service;

import com.ikun.wms.pojo.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author yiwan
* @description 针对表【user_info(用户表)】的数据库操作Service
* @createDate 2024-07-18 16:23:43
*/
public interface UserService extends IService<User> {
    User login(User user);
}
