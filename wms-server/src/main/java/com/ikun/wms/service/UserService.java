package com.ikun.wms.service;

import com.ikun.wms.pojo.entity.User;

/**
 * @Author: yiwang
 * @Date: 2024/7/18
 */
public interface UserService {
    User login(String userName, String userPwd);
}
