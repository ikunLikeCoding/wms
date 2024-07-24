package com.ikun.wms.pojo.query;

import lombok.Data;

/**
 * @Author: yiwang
 * @Date: 2024/7/23
 */

@Data
public class UserQuery extends BaseQuery{
    private String userName;
    private String userState;
    private String roleId;
}
