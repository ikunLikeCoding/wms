package com.ikun.wms.pojo.query;

import lombok.Data;

/**
 * @Author: yiwang
 * @Date: 2024/7/24
 */
@Data
public class RoleQuery extends BaseQuery{
    private String roleName;
    private String roleCode;
    private String roleState;
}
