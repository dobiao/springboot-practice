package com.souche.db.service;

import org.springframework.stereotype.Service;

/**
 * Created by dubiao on 2017/9/27.
 */
// service("unifiedIdService") 启动Spring时创建一个叫unifiedIdService的bean
@Service("unifiedIdService")
public class UnifiedIdService {

    public Integer getNewAge(Integer age) {

        return 18;
    }

}
