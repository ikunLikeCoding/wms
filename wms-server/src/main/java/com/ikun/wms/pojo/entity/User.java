package com.ikun.wms.pojo.entity;

import java.io.Serializable;
import java.util.Date;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;

/**
 * 用户表
 * @TableName user_info
 */
@Data
public class User implements Serializable {
    /**
     * 
     */
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

    private static final long serialVersionUID = 6595119121277161460L;
}