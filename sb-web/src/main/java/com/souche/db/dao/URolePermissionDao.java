package com.souche.db.dao;

import org.apache.ibatis.annotations.Mapper;

import com.souche.db.constant.BaseDao;
import com.souche.db.entity.URolePermission;

@Mapper
public interface URolePermissionDao extends BaseDao<URolePermission, Long> {

    /**
     * 增加对象
     * @param obj
     */
    //public void add(SysMessageTep	 obj);
}