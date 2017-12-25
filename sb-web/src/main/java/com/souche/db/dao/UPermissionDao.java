package com.souche.db.dao;


import com.souche.db.constant.BaseDao;
import com.souche.db.entity.UPermission;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface UPermissionDao extends BaseDao<UPermission, Long> {



    /**
     * 根据用户id获取用户权限
     * @param obj
     */
    List<UPermission> findPermissionByUid(Long id);
}