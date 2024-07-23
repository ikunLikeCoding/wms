package com.ikun.wms.controller;

/**
 * @Author: yiwang
 * @Date: 2024/7/22
 */

import com.ikun.wms.pojo.entity.Role;
import com.ikun.wms.service.RoleService;
import com.ikun.wms.utils.Result;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/***
 * 角色管理
 */
@RestController
@RequestMapping("/role")
public class RoleController {

    @Resource
    private RoleService roleService;

    @GetMapping("/role-list")
    public Result<List<Role>> roleList() {
        return Result.success(roleService.list());
    }
}
