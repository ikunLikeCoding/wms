package com.ikun.wms.pojo.dto;

import com.ikun.wms.pojo.entity.Role;
import lombok.Data;

import java.util.List;

/**
 * @Author: yiwang
 * @Date: 2024/7/24
 */

@Data
public class UserDTO {
   private Integer userId;
   private String userCode;
    // 角色列表
   private List<Role> roleList;
    // 被选中的角色列表
   private List<String> roleCheckList;
}
