package com.souche.db.service;

import com.souche.db.entity.URole;

import java.util.List;

public interface URoleService {
    public List<URole> findRoleByUid(Long	 obj);

}
