package com.ikun.wms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ikun.wms.mapper.AuthInfoMapper;
import com.ikun.wms.pojo.dto.UserDTO;
import com.ikun.wms.pojo.entity.Role;
import com.ikun.wms.pojo.entity.User;

import com.ikun.wms.mapper.UserInfoMapper;
import com.ikun.wms.pojo.entity.UserRole;
import com.ikun.wms.pojo.query.UserQuery;
import com.ikun.wms.pojo.vo.UserVO;
import com.ikun.wms.service.UserRoleService;
import com.ikun.wms.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
    @Transactional
    public int roleAssign(UserDTO user) {
        User current = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        List<Integer> roleIds = new ArrayList<>();
        List<Role> roleList = user.getRoleList();
        Map<String, Integer> roleNameIdMap = roleList.stream()
                .collect(Collectors.toMap(Role::getRoleName, Role::getRoleId));

        //先删除该用户的所有角色
        userRoleService.removeByUserId(user.getUserId());

        //根据用角色名映射角色id
        List<String> roleCheckList = user.getRoleCheckList();
        roleCheckList.forEach(role -> roleIds.add(roleNameIdMap.get(role)));


        //批量插入
        boolean b = userRoleService.saveBatch(roleIds.stream().map(roleId -> {
            UserRole userRole = new UserRole();
            userRole.setRoleId(roleId);
            userRole.setUserId(user.getUserId());
            return userRole;
        }).collect(Collectors.toList()));

        if (b) {
            return 1;
        }

        return 0;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return findByUserName(username);
    }
}




