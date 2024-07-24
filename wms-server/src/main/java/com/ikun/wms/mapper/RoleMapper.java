package com.ikun.wms.mapper;

import com.ikun.wms.pojo.dto.AuthTree;
import com.ikun.wms.pojo.dto.RoleAuthDTO;
import com.ikun.wms.pojo.entity.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ikun.wms.pojo.query.RoleQuery;
import com.ikun.wms.pojo.vo.RoleVO;

import java.util.List;

/**
* @author yiwan
* @description 针对表【role(角色表)】的数据库操作Mapper
* @createDate 2024-07-18 16:23:43
* @Entity com.ikun.wms.pojo.entity.Role
*/
public interface RoleMapper extends BaseMapper<Role> {

    List<RoleVO> getRoleByPageAndCondition(RoleQuery roleQuery);

    List<AuthTree> getAuthTreeByRoleId(Integer roleId);

    int deleteByRoleId(Integer roleId);

    int insertBatch(RoleAuthDTO roleAuthDTO);
}




