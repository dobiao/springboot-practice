package com.souche.db.controller;

import com.souche.db.annotation.MethodCache;
import com.souche.db.annotation.Validate;
import com.souche.db.model.User;
import com.souche.db.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    private Logger logger = Logger.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping("/getUserInfo")
    @ResponseBody
    public User getUserInfo() {
        User user = userService.getUserInfo();
        if (user != null) {
            //System.out.println("user.getName():"+user.getName());
            logger.info("user.getAge():" + user.getAge());
        }
        return user;
    }

    @RequestMapping("/test1")
    @ResponseBody

    @Validate("zxc")
    public User getUserInfo1(@RequestParam("name") String name) {
        System.out.println(name);
        return userService.getUserInfo();
    }

    @RequestMapping("/test2")

    @ResponseBody
    public User getUserInfo2() {

        User u = new User();
        u.setName("andy");
        userService.createUser(u);
        return new User();
    }

    @RequestMapping("/test3")
    @ResponseBody
    @MethodCache(expire = 15)
    public String getUserInfo3(@RequestParam("name") String name,@RequestParam("year") String year) {
        System.out.println(name);
        return userService.getUserInfo().getName();
    }
}
