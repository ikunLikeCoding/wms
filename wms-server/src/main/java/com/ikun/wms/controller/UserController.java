package com.ikun.wms.controller;

import com.ikun.wms.pojo.dto.AuthTree;
import com.ikun.wms.pojo.entity.AuthInfo;
import com.ikun.wms.pojo.entity.User;
import com.ikun.wms.service.AuthInfoService;
import com.ikun.wms.service.UserService;
import com.ikun.wms.utils.JSONUtils;
import com.ikun.wms.utils.JWTUtils;
import com.ikun.wms.utils.Result;
import jakarta.annotation.Resource;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: yiwang
 * @Date: 2024/7/18
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private AuthInfoService authInfoService;


    @GetMapping("/auth-list")
    public Result authList() {

        return Result.success(authInfoService.getAuthTreeByUserId());
    }

    @GetMapping("/current")
    public Result<User> current() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return Result.success(user);
    }
}
