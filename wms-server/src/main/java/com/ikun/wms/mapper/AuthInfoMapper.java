package com.ikun.wms.mapper;

import com.ikun.wms.pojo.dto.AuthTree;
import com.ikun.wms.pojo.entity.AuthInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author yiwan
* @description 针对表【auth_info(权限表)】的数据库操作Mapper
* @createDate 2024-07-18 16:23:43
* @Entity com.ikun.wms.pojo.entity.AuthInfo
*/

public interface AuthInfoMapper extends BaseMapper<AuthInfo> {


    List<AuthTree> getAuthTreeByUserId();
}




