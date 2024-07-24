package com.ikun.wms.pojo.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @Author: yiwang
 * @Date: 2024/7/24
 */

@Data
public class RoleVO {
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

    private String createByName;
    /**
     *
     */
    private LocalDateTime createTime;

    /**
     *
     */
    private Integer updateBy;
    private String updateByName;

    /**
     *
     */
    private LocalDateTime updateTime;
}
