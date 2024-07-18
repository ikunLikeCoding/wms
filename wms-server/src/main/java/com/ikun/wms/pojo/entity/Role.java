package com.ikun.wms.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * 角色表
 * @TableName role
 */
@TableName(value ="role")
@Data
public class Role implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
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
    private LocalDateTime createTime;

    /**
     * 
     */
    private Integer updateBy;

    /**
     * 
     */
    private LocalDateTime updateTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}