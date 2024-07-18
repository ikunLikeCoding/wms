package com.ikun.wms.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * 用户表
 * @TableName user_info
 */
@TableName(value ="user_info")
@Data
public class User implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer userId;

    /**
     * 
     */
    private String userCode;

    /**
     * 
     */
    private String userName;

    /**
     * 
     */
    private String userPwd;

    /**
     * 1 超级管理员 、 2  管理员 、 3 普通用户
     */
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

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}