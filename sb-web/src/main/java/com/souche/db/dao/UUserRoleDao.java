package com.souche.db.dao;

import com.souche.db.constant.BaseDao;
import com.souche.db.entity.UUserRole;
import org.mapstruct.Mapper;

@Mapper
public interface UUserRoleDao extends BaseDao<UUserRole, Long> {

    /**
     * 增加对象
     * @param obj
     */
    //public void add(SysMessageTep	 obj);
}
