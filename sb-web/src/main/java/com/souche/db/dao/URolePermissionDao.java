package com.souche.db.dao;

import com.souche.db.constant.BaseDao;
import com.souche.db.entity.URolePermission;
import org.mapstruct.Mapper;

@Mapper
public interface URolePermissionDao extends BaseDao<URolePermission, Long> {

    /**
     * 增加对象
     * @param obj
     */
    //public void add(SysMessageTep	 obj);
}