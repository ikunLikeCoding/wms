package com.ikun.wms.pojo.vo;

import com.alibaba.fastjson2.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @Author: yiwang
 * @Date: 2024/7/23
 */
@Data
public class UserVO {
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

    private String createByCode;

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
}
