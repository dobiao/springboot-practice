package com.souche.test;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.souche.db.model.User;

import java.util.List;

import static com.alibaba.fastjson.serializer.SerializerFeature.PrettyFormat;
import static com.alibaba.fastjson.serializer.SerializerFeature.WriteMapNullValue;
import static com.alibaba.fastjson.serializer.SerializerFeature.WriteNullStringAsEmpty;

public class A {

    public static void main(String[] args) {


        User u1 = new User();


        User u2 = new User();

        u2.setAge(11);

        System.out.println(JSON.toJSONString(u1, WriteNullStringAsEmpty, WriteMapNullValue, PrettyFormat));
        u1 = u2;

        System.out.println(JSON.toJSONString(u1, WriteNullStringAsEmpty, WriteMapNullValue, PrettyFormat));


    }


}
