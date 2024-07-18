package com.ikun.wms.service.impl;

import com.ikun.wms.mapper.UserInfoMapper;
import com.ikun.wms.pojo.entity.User;
import com.ikun.wms.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * @Author: yiwang
 * @Date: 2024/7/18
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserInfoMapper userMapper;
    @Override
    public User login(String userName, String userPwd) {
        User user = userMapper.getUserByName(userName);
        if (user == null)return null;
        if (user.getUserPwd().equals(userPwd))return user;

        return null;
    }
}
