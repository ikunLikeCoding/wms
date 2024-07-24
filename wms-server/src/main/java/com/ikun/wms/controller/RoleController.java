package com.ikun.wms.controller;

/**
 * @Author: yiwang
 * @Date: 2024/7/22
 */

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.github.pagehelper.PageInfo;
import com.ikun.wms.pojo.dto.AuthTree;
import com.ikun.wms.pojo.dto.RoleAuthDTO;
import com.ikun.wms.pojo.entity.Role;
import com.ikun.wms.pojo.entity.User;
import com.ikun.wms.pojo.query.RoleQuery;
import com.ikun.wms.pojo.vo.RoleVO;
import com.ikun.wms.service.RoleService;
import com.ikun.wms.utils.Result;
import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

/***
 * 角色管理
 */
@RestController
@RequestMapping("/role")
public class RoleController {

    private static final Logger log = LoggerFactory.getLogger(RoleController.class);
    @Resource
    private RoleService roleService;

    @GetMapping("/role-list")
    public Result<List<Role>> roleList() {
        return Result.success(roleService.list());
    }
    @GetMapping("/role-page-list")
    public Result<PageInfo<RoleVO>> rolePageList(RoleQuery roleQuery) {
            log.info("角色查询roleQuery:{}", roleQuery);
        PageInfo<RoleVO> rolePageInfo = roleService.getRoleByPageAndCondition(roleQuery);
        return Result.success(rolePageInfo);
    }

    @PostMapping("/role-add")
    public Result<String> roleAdd(@RequestBody Role role) {

        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        log.info("角色添加role:{}", role);
        role.setRoleState("0");
        role.setCreateBy(user.getUserId());
        role.setUpdateBy(user.getUserId());
        role.setCreateTime(LocalDateTime.now());
        role.setUpdateTime(LocalDateTime.now());
        roleService.save(role);
        return Result.success("角色添加成功");
    }

    @GetMapping("/role-code-verify/{roleCode}")
    public Result<Boolean> roleCodeVerify(@PathVariable("roleCode") String roleCode) {
        QueryWrapper<Role> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("role_code", roleCode);
        Role byId = roleService.getOne(queryWrapper);
        log.info("角色查询roleCode:{}", roleCode);
        if (byId != null) {
            log.info("exist");
            return Result.success(false);
        }

        return Result.success(true);
    }


    @PutMapping("/role-state-update")
    public Result roleStateUpdate(@RequestBody Role role) {
        log.info("角色状态修改role:{}", role);

        UpdateWrapper<Role> updateWrapper = new UpdateWrapper();
        updateWrapper.eq("role_id",role.getRoleId());
        updateWrapper.set("role_state",role.getRoleState());
        boolean update = roleService.update(updateWrapper);
        if (!update) {
            return Result.error();
        }
        return Result.success();
    }

    @PutMapping("/role-update")
    public Result roleUpdate(@RequestBody Role role) {
        log.info("角色修改role:{}", role);

        boolean update = roleService.updateById(role);
        if (!update) {
            return Result.error();
        }
        return Result.success();
    }

    @DeleteMapping("/role-delete/{id}")
    public Result roleDelete(@PathVariable("id") Integer id) {
        boolean b = roleService.removeById(id);
        if (!b) {
            return Result.error();
        }
        return Result.success();
    }


    @GetMapping("/role-auth/{roleId}")
    public Result<List<AuthTree>> roleAuth(@PathVariable("roleId") Integer roleId) {
        List<AuthTree> authTreeByRoleId  = roleService.getAuthTreeByRoleId(roleId);
        return Result.success(authTreeByRoleId);
    }

    @PutMapping("/auth-grant")
    public Result authGrant(@RequestBody RoleAuthDTO roleAuthDTO) {
        log.info("角色授权roleAuthDTO:{}", roleAuthDTO);
        boolean b = roleService.authGrant(roleAuthDTO);
        if (!b) {
            return Result.error();
        }
        return Result.success();
    }

}
