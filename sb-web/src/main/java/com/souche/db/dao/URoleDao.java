package com.souche.db.dao;

import com.souche.db.constant.BaseDao;
import com.souche.db.entity.URole;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface URoleDao extends BaseDao<URole, Long> {

    /**
     * 根据用户ID获取该用户所在组的角色权限
     * @param obj
     */
    public List<URole> findRoleByUid(Long obj);
}