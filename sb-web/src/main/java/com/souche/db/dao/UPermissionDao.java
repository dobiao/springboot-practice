package com.souche.db.dao;


import com.souche.db.constant.BaseDao;
import com.souche.db.entity.UPermission;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UPermissionDao extends BaseDao<UPermission, Long> {



    /**
     * 根据用户id获取用户权限
     * @param obj
     */
    List<UPermission> findPermissionByUid(Long id);
}