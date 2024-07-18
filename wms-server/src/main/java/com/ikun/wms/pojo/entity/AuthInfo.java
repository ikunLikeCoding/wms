package com.ikun.wms.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * 权限表
 * @TableName auth_info
 */
@TableName(value ="auth_info")
@Data
public class AuthInfo implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer authId;

    /**
     * 父id为空或为0，表示一级权限
     */
    private Integer parentId;

    /**
     * 
     */
    private String authName;

    /**
     * 
     */
    private String authDesc;

    /**
     * 
     */
    private Integer authGrade;

    /**
     * 1 模块 、2  列表、 3  按钮
     */
    private String authType;

    /**
     * 
     */
    private String authUrl;

    /**
     * 
     */
    private String authCode;

    /**
     * 
     */
    private Integer authOrder;

    /**
     * 1 启用 、0 禁用
     */
    private String authState;

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