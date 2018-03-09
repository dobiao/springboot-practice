package com.souche.db.dao;

import org.apache.ibatis.annotations.Mapper;

import com.souche.db.constant.BaseDao;
import com.souche.db.entity.UUserRole;

@Mapper
public interface UUserRoleDao extends BaseDao<UUserRole, Long> {

    /**
     * 增加对象
     * @param obj
     */
    //public void add(SysMessageTep	 obj);
}
