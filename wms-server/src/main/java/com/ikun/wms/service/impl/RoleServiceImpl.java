package com.ikun.wms.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ikun.wms.pojo.dto.AuthTree;
import com.ikun.wms.pojo.dto.RoleAuthDTO;
import com.ikun.wms.pojo.entity.Role;
import com.ikun.wms.pojo.entity.RoleAuth;
import com.ikun.wms.pojo.query.RoleQuery;
import com.ikun.wms.pojo.vo.RoleVO;
import com.ikun.wms.service.RoleService;
import com.ikun.wms.mapper.RoleMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
* @author yiwan
* @description 针对表【role(角色表)】的数据库操作Service实现
* @createDate 2024-07-18 16:23:43
*/
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role>
    implements RoleService{

    @Resource
    private RoleMapper roleMapper;
    @Override
    public PageInfo<RoleVO> getRoleByPageAndCondition(RoleQuery roleQuery) {
        PageHelper.startPage(roleQuery.getCurrentPage(), roleQuery.getPageSize());



        return new PageInfo<>(roleMapper.getRoleByPageAndCondition(roleQuery));
    }

    @Override
    public List<AuthTree> getAuthTreeByRoleId(Integer roleId) {
        return roleMapper.getAuthTreeByRoleId(roleId);
    }

    @Transactional
    @Override
    public boolean authGrant(RoleAuthDTO roleAuthDTO) {

        int i = roleMapper.deleteByRoleId(roleAuthDTO.getRoleId());
        int count = roleMapper.insertBatch(roleAuthDTO);
        return count > 0;
    }
}




