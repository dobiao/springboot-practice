package com.souche.db.service.impl;

import com.souche.db.dao.UPermissionDao;
import com.souche.db.entity.UPermission;
import com.souche.db.service.UPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UPermissionServiceImpl implements UPermissionService{

    //@Autowired
    UPermissionDao permissionDao;
    @Override
    public List<UPermission> findPermissionByUid(Long id) {
        return permissionDao.findPermissionByUid(id);
    }
}
