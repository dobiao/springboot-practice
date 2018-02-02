package com.souche.test;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.souche.db.model.User;
import org.springframework.beans.BeanUtils;

import java.util.List;

import static com.alibaba.fastjson.serializer.SerializerFeature.PrettyFormat;
import static com.alibaba.fastjson.serializer.SerializerFeature.WriteMapNullValue;
import static com.alibaba.fastjson.serializer.SerializerFeature.WriteNullStringAsEmpty;

public class A {

    public static void main(String[] args) {

        User u1 = new User();

        System.out.println(JSON.toJSONString(u1, WriteNullStringAsEmpty, WriteMapNullValue, PrettyFormat));
        A a = new A();
        a.convert(u1);
        //a.convert2(u1);
        //a.convert3(u1);
        System.out.println(JSON.toJSONString(u1, WriteNullStringAsEmpty, WriteMapNullValue, PrettyFormat));

    }

    public void convert(User user) {
        User u2 = new User();
        u2.setAge(11);
        user = u2;

    }
    public void convert2(User user) {
        User u2 = new User();
        u2.setAge(11);
        //user = u2;
        BeanUtils.copyProperties(u2, user);
    }

    public void convert3(User user) {
       user.setAge(11);
    }


}
