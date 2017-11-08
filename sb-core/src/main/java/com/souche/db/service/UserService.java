package com.souche.db.service;

import com.souche.db.annotation.PassportAccountIdHandler;
import com.souche.db.mapper.UserMapper;
import com.souche.db.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * Created by zl on 2015/8/27.
 */

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User getUserInfo(@PassportAccountIdHandler Integer age) {
        User user = userMapper.findUserInfo(age);
        //User user=null;
        return user;
    }
    public void createUser(@PassportAccountIdHandler("age") User user){
        if (user == null || StringUtils.isEmpty(user.getAge())) return;
        Integer age = user.getAge();
        // TODO
    }
}
