package com.ikun.wms.pojo.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * 角色权限表
 * @TableName role_auth
 */
@Data
public class RoleAuth implements Serializable {
    /**
     * 
     */
    private Integer roleAuthId;

    /**
     * 
     */
    private Integer roleId;

    /**
     * 
     */
    private Integer authId;

    private static final long serialVersionUID = 1L;
}