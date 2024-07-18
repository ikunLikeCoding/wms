package com.ikun.wms.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 角色权限表
 * @TableName role_auth
 */
@TableName(value ="role_auth")
@Data
public class RoleAuth implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer roleAuthId;

    /**
     * 
     */
    private Integer roleId;

    /**
     * 
     */
    private Integer authId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}