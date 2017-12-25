package com.souche.db.dao;

import com.souche.db.constant.BaseDao;
import com.souche.db.entity.UUser;
import org.mapstruct.Mapper;

@Mapper
public interface UUserDao extends BaseDao<UUser, Long> {

    /**
     * 增加对象
     * @param obj
     */
    public UUser findByName(String	 name);
}