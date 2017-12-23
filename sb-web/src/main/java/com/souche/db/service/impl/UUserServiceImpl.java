package com.souche.db.service.impl;

import com.souche.db.dao.UUserDao;
import com.souche.db.entity.UUser;
import com.souche.db.service.UUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UUserServiceImpl implements UUserService{

    @Autowired
    private UUserDao uUserDao;

    @Override
    public UUser findByName(String name) {
        return uUserDao.findByName(name);
    }
}
