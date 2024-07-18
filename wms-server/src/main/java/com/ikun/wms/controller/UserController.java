package com.ikun.wms.controller;

import com.ikun.wms.pojo.entity.User;
import com.ikun.wms.service.UserService;
import com.ikun.wms.utils.JSONUtils;
import com.ikun.wms.utils.JWTUtils;
import com.ikun.wms.utils.Result;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: yiwang
 * @Date: 2024/7/18
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    @GetMapping("/login")
    public Result login(User user) {
        User login = userService.login(user.getUserName(), user.getUserPwd());
        if (login == null) {
            return Result.error("登录失败");
        }
        String jwt = JWTUtils.createJWT(JSONUtils.toJSON(login));
        return Result.success(jwt);
    }
}
