package com.ikun.wms;

import com.github.pagehelper.PageInfo;
import com.ikun.wms.mapper.UserRoleMapper;
import com.ikun.wms.pojo.entity.AuthInfo;
import com.ikun.wms.pojo.entity.Role;
import com.ikun.wms.pojo.entity.User;
import com.ikun.wms.pojo.query.UserQuery;
import com.ikun.wms.pojo.vo.UserVO;
import com.ikun.wms.service.UserService;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @Author: yiwang
 * @Date: 2024/7/23
 */

@SpringBootTest
public class UserTest {
    @Resource
    private UserService userService;

    @Resource
    private UserRoleMapper userRoleMapper;
    @Test
    public void testFindByUserName() {
        User 超级管理员 = userService.findByUserName("admin");
        System.out.println(超级管理员);

    }

    @Test
    public void testFindUserByPageAndCondition() {
        UserQuery userQuery = new UserQuery();
        userQuery.setCurrentPage(1);
        userQuery.setPageSize(10);
//        userQuery.setRoleName("普通用户");
//        userQuery.setUserName("admin");
//        userQuery.setUserState("1");
        PageInfo<UserVO> userPageList = userService.findUserByPageAndCondition(userQuery);
        System.out.println(userPageList);
    }

    @Test
    public void testGetRoleList() {
        List<Role> roleListByUserId = userRoleMapper.getRoleListByUserId(4);

        System.out.println(roleListByUserId);
    }

}
