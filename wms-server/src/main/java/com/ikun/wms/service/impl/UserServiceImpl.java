package com.ikun.wms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ikun.wms.pojo.entity.User;

import com.ikun.wms.mapper.UserInfoMapper;
import com.ikun.wms.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
* @author yiwan
* @description 针对表【user_info(用户表)】的数据库操作Service实现
* @createDate 2024-07-18 16:23:43
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserInfoMapper, User>
    implements UserService {

    @Resource
    private UserInfoMapper userMapper;

    @Override
    public User login(User user) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_name", user.getUserName());

        return userMapper.selectOne(queryWrapper);
    }
}




