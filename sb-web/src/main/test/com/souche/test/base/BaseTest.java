package com.souche.test.base;

import com.alibaba.fastjson.JSON;
import com.souche.db.Application;
import com.souche.db.model.User;
import com.souche.db.tool.ObjectOutputTool;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.util.Assert;

import java.util.List;

import static com.alibaba.fastjson.serializer.SerializerFeature.PrettyFormat;
import static com.alibaba.fastjson.serializer.SerializerFeature.WriteMapNullValue;
import static com.alibaba.fastjson.serializer.SerializerFeature.WriteNullStringAsEmpty;

/**
 * Created by dubiao on 2017/9/26.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class BaseTest {


    protected void print(Object o) {
        System.out.println("-------------------TEST RESULT-------------------");
        System.out.println(JSON.toJSONString(o, WriteNullStringAsEmpty, WriteMapNullValue, PrettyFormat));
    }

    protected void printThenCheck(Object o) {
        print(o);
        Assert.notNull(o, o.getClass().getName());
    }


    @Autowired
    private ObjectOutputTool oot;

    @Test
    public void getAllcarTest() {


        this.print(oot.outObjPropertyString(new User()));

    }


}
