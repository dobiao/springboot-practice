package com.souche.db.dao;

import com.souche.db.constant.BaseDao;
import com.souche.db.entity.URole;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface URoleDao extends BaseDao<URole, Long> {

    /**
     * 根据用户ID获取该用户所在组的角色权限
     * @param obj
     */
    public List<URole> findRoleByUid(Long	 obj);
}