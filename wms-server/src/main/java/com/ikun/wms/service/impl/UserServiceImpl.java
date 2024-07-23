package com.ikun.wms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ikun.wms.mapper.AuthInfoMapper;
import com.ikun.wms.pojo.dto.AuthTree;
import com.ikun.wms.pojo.entity.AuthInfo;
import com.ikun.wms.pojo.entity.Role;
import com.ikun.wms.pojo.entity.User;

import com.ikun.wms.mapper.UserInfoMapper;
import com.ikun.wms.pojo.query.UserQuery;
import com.ikun.wms.pojo.vo.UserVO;
import com.ikun.wms.service.UserRoleService;
import com.ikun.wms.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
    @Resource
    private AuthInfoMapper authInfoMapper;

    @Resource
    private UserRoleService userRoleService;
    @Override
    public User findByUserName(String userCode) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_code", userCode);

        User user = userMapper.selectOne(queryWrapper);

        List<String> roleList = new ArrayList<>();
        List<Role> list = this.getRoleList(user.getUserId());
        list.forEach(role -> {
            roleList.add(role.getRoleName());
        });

        user.setRoleList(roleList);

        return user;
    }

    @Override
    public PageInfo<UserVO> findUserByPageAndCondition(UserQuery userQuery) {
        PageHelper.startPage(userQuery.getCurrentPage(), userQuery.getPageSize());
        List<UserVO> users = userMapper.findUserByPageAndCondition(userQuery);
        return new PageInfo<>(users);
    }

    @Override
    public int updateUserState(User user) {
        UpdateWrapper<User> queryWrapper = new UpdateWrapper<>();
        queryWrapper.eq("user_id", user.getUserId());
        return userMapper.update(user, queryWrapper);
    }

    @Override
    public List<Role> getRoleList(Integer id) {
        return userMapper.getRoleList(id);
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return findByUserName(username);
    }
}




