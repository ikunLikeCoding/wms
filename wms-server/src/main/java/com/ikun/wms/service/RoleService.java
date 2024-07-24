package com.ikun.wms.service;

import com.github.pagehelper.PageInfo;
import com.ikun.wms.pojo.dto.AuthTree;
import com.ikun.wms.pojo.dto.RoleAuthDTO;
import com.ikun.wms.pojo.entity.Role;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ikun.wms.pojo.query.RoleQuery;
import com.ikun.wms.pojo.vo.RoleVO;

import java.util.List;

/**
* @author yiwan
* @description 针对表【role(角色表)】的数据库操作Service
* @createDate 2024-07-18 16:23:43
*/
public interface RoleService extends IService<Role> {

    PageInfo<RoleVO> getRoleByPageAndCondition(RoleQuery roleQuery);

    List<AuthTree> getAuthTreeByRoleId(Integer roleId);

    boolean authGrant(RoleAuthDTO roleAuthDTO);
}
