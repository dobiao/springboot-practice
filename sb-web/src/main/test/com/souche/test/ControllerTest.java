package com.souche.test;

import com.souche.db.service.UserService;
import com.souche.test.base.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by dubiao on 2017/9/27.
 */
public class ControllerTest extends BaseTest{



    @Autowired
    private UserService userService;

    @Test
    public void setUserService() {

        this.print(userService.getUserInfo(12));
    }




}
