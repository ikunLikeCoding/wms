package com.ikun.wms.pojo.entity;

import com.alibaba.fastjson2.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.ObjectUtils;

/**
 * 用户表
 * @TableName user_info
 */
@TableName(value ="user_info")
@Data
public class User implements Serializable , UserDetails {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer userId;

    /**
     * 账号
     */
    private String userCode;

    /**
     * 
     */
    private String userName;

    /**
     * 
     */
    @JSONField(serialize = false)
    private String userPwd;

    /**
     * 1 超级管理员 、 2  管理员 、 3 普通用户
     */
    @JSONField(serialize = false)

    private String userType;

    /**
     * 0 未审核 、1 已审核
     */
    private String userState;

    /**
     * 0 正常、 1 已删除
     */
    private String isDelete;

    /**
     * 
     */
    private Integer createBy;

    /**
     * 
     */
    private LocalDateTime createTime;

    /**
     * 
     */
    private Integer updateBy;

    /**
     * 
     */
    private LocalDateTime updateTime;


    /***
     * 权限
     */
    @TableField(exist = false)
    private List<String> roleList;
    /***
     * 权限标识符
     */
    @TableField(exist = false)
    private List<String> permissionList;

    /***
     * 菜单权限
     */
//    private List<PermissionDTO> menuPermissionList;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @JSONField(serialize = false)
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> list = new ArrayList<>();

        if (!ObjectUtils.isEmpty(this.getRoleList())) {
            this.getRoleList().forEach(role -> {
                list.add(new SimpleGrantedAuthority(role));
            });
        }

        if(!ObjectUtils.isEmpty(this.getPermissionList())) {
            this.getPermissionList().forEach(permission -> {
                list.add(new SimpleGrantedAuthority(permission));
            });
        }
        return list;
    }

    @JSONField(serialize = false)
    @Override
    public String getPassword() {
        return this.userPwd;
    }
    @Override
    public String getUsername() {
        return this.userName;
    }
    @JSONField(serialize = false)
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    @JSONField(serialize = false)
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    @JSONField(serialize = false)
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    @JSONField(serialize = false)
    @Override
    public boolean isEnabled() {
        return true;
    }
}