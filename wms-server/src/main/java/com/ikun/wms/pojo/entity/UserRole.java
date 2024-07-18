package com.ikun.wms.pojo.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * 用户角色表
 * @TableName user_role
 */
@Data
public class UserRole implements Serializable {
    /**
     * 
     */
    private Integer userRoleId;

    /**
     * 
     */
    private Integer roleId;

    /**
     * 
     */
    private Integer userId;

    private static final long serialVersionUID = 1L;
}