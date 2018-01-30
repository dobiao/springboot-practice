package com.souche.db.service.impl;

import com.souche.db.dao.URoleDao;
import com.souche.db.entity.URole;
import com.souche.db.service.URoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class URoleServiceImpl implements URoleService{

    //@Autowired
    private URoleDao uRoleDao;

    @Override
    public List<URole> findRoleByUid(Long	 obj){
        return uRoleDao.findRoleByUid(obj);
    }
}
