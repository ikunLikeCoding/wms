package com.ikun.wms.controller;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.pagehelper.PageInfo;
import com.ikun.wms.pojo.dto.AuthTree;
import com.ikun.wms.pojo.dto.UserDTO;
import com.ikun.wms.pojo.entity.AuthInfo;
import com.ikun.wms.pojo.entity.Role;
import com.ikun.wms.pojo.entity.User;
import com.ikun.wms.pojo.query.UserQuery;
import com.ikun.wms.pojo.vo.UserVO;
import com.ikun.wms.service.AuthInfoService;
import com.ikun.wms.service.RoleService;
import com.ikun.wms.service.UserService;
import com.ikun.wms.utils.JSONUtils;
import com.ikun.wms.utils.JWTUtils;
import com.ikun.wms.utils.Result;
import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * @Author: yiwang
 * @Date: 2024/7/18
 */
@RestController
@RequestMapping("/user")
public class UserController {
    private static final Logger log = LoggerFactory.getLogger(UserController.class);
    @Resource
    private AuthInfoService authInfoService;

    @Resource
    private UserService userService;


    @Resource
    private PasswordEncoder passwordEncoder;
    @GetMapping("/auth-list")
    public Result authList() {

        return Result.success(authInfoService.getAuthTreeByUserId());
    }

    @GetMapping("/current")
    public Result<User> current() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return Result.success(userService.findByUserName(user.getUserCode()));
    }

    @GetMapping("/user-page-list")
    public Result getUserPageList(UserQuery userQuery) {
        log.info("userQuery:{}",userQuery);
        PageInfo<UserVO> userPageInfo = userService.findUserByPageAndCondition(userQuery);
        return Result.success(userPageInfo);
    }

    @PostMapping("/user-add")
    public Result userAdd(@RequestBody User user) {
        log.info("addUser:{}",user);
        User current = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        user.setCreateBy(current.getUserId());
        user.setCreateTime(LocalDateTime.now());
        user.setUpdateBy(current.getUserId());
        user.setUpdateTime(LocalDateTime.now());
        user.setIsDelete("0");
        user.setUserState("0");
        boolean save = userService.save(user);
        if (!save) {
            return Result.error("添加失败");
        }
        return Result.success();
    }

    @GetMapping("/user-code-verify")
    public Result userCodeVerify(String userCode) {
        log.info("userCode:{}",userCode);
        if (userService.findByUserName(userCode) != null) {
            return Result.success(false,"用户名已存在");
        }
        return Result.success();
    }


    @PutMapping("/state-update")
    public Result userStateUpdate(@RequestBody User user) {
        log.info("updateUserState:{}",user);
        int success = userService.updateUserState(user);
        if (success == 0) {
            return Result.error("更新失败");
        }
        return Result.success();
    }

    @PutMapping("/user-update")
    public Result userUpdate(@RequestBody User user) {

        boolean b = userService.updateById(user);
        if (!b) {
            return Result.error("更新失败");
        }
        return Result.success();
    }

    @DeleteMapping("/user-delete/{id}")
    public Result userDelete(@PathVariable("id") Integer id) {
        log.info("userDelete:{}",id);
        boolean b = userService.removeById(id);
        if (!b) {
            return Result.error("删除失败");
        }
        return Result.success();
    }
    @GetMapping("/user-role-list/{id}")
    public Result userRoleList(@PathVariable Integer id) {
        log.info("获取当前用户的userRoleList:{}",id);

        List<Role> roleList = userService.getRoleList(id);
        return Result.success(roleList);
    }

    @PutMapping("/role-assign")
    public Result roleAssign(@RequestBody UserDTO user) {
        log.info("角色赋值roleAssign:{}",user);
        int i = userService.roleAssign(user);
        if (i == 0) {
            return Result.error("角色赋值失败");
        }
        return Result.success();
    }


    /***
     * 重置密码为123456
     * @param id 用户id
     * @return
     */
    @PutMapping("/password-reset/{id}")
    public Result userPwdReset(@PathVariable("id") Integer id) {
        log.info("userPwdReset:{}",id);
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
        updateWrapper.set("user_pwd",passwordEncoder.encode("123456"));
        updateWrapper.eq("user_id",id);
        boolean update = userService.update(updateWrapper);

        if(!update) {
            return Result.error("重置失败");
        }

        return Result.success("重置成功");
    }
}
