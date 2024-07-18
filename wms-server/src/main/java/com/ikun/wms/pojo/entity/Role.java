package com.ikun.wms.pojo.entity;

import java.io.Serializable;
import java.util.Date;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;

/**
 * 角色表
 * @TableName role
 */
@Data
public class Role implements Serializable {
    /**
     * 
     */
    private Integer roleId;

    /**
     * 
     */
    private String roleName;

    /**
     * 
     */
    private String roleDesc;

    /**
     * 
     */
    private String roleCode;

    /**
     * 1 启用 0 禁用
     */
    private String roleState;

    /**
     * 
     */
    private Integer createBy;

    /**
     * 
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    /**
     * 
     */
    private Integer updateBy;

    /**
     * 
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    private static final long serialVersionUID = 1L;
}