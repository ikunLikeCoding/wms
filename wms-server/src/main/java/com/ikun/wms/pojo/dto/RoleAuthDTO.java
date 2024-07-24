package com.ikun.wms.pojo.dto;

import lombok.Data;

import java.util.List;

/**
 * @Author: yiwang
 * @Date: 2024/7/24
 */

@Data
public class RoleAuthDTO {
    private Integer roleId;
    private List<Integer> authIds;
}
