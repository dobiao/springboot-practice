package com.souche.db.service;

import com.souche.db.entity.UPermission;

import java.util.List;

public interface UPermissionService {
    /**
     * 根据用户id获取用户权限
     * @param obj
     */
    List<UPermission> findPermissionByUid(Long id);
}
