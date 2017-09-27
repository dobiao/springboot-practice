package com.souche.test.base;

import com.alibaba.fastjson.JSON;
import com.souche.db.Application;
import com.souche.db.tool.ObjectOutputTool;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import static com.alibaba.fastjson.serializer.SerializerFeature.*;

/**
 * Created by dubiao on 2017/9/26.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class BaseTest {

    @Autowired
    private ObjectOutputTool oot;


    protected void print(Object o) {
        System.out.println("-------------------TEST RESULT-------------------");
        System.out.println(JSON.toJSONString(o, WriteNullStringAsEmpty, WriteMapNullValue, PrettyFormat));
    }


    protected void printWithTool(Object o) {
        System.out.println(oot.outObjPropertyString(o));

    }

    protected void printThenCheck(Object o) {
        print(o);
        Assert.notNull(o, o.getClass().getName());
    }

}
