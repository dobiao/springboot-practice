package com.souche.db.hutool;

import com.xiaoleilu.hutool.db.Entity;
import com.xiaoleilu.hutool.db.SqlRunner;
import com.xiaoleilu.hutool.io.resource.ClassPathResource;
import com.xiaoleilu.hutool.json.JSONObject;
import com.xiaoleilu.hutool.json.JSONUtil;
import com.xiaoleilu.hutool.log.Log;
import com.xiaoleilu.hutool.log.LogFactory;

import java.sql.SQLException;
import java.util.List;

public class HuToolDemo {

    public static final Log log = LogFactory.get();

    public static void main(String[] args) {
        textDBQuery();
        textReadFile();
        textJSON_Log();
    }

    public static void textReadFile(){
        String address = new ClassPathResource("application.yml").getPath();
        System.out.println(address);
        // 这里不知道为什么没有readUtf8Str方法
//        String text = ResourceUtil.readUtf8Str("application.yml");
//        System.out.println(text);
    }
    public static void textJSON_Log(){
        String json = "[{\"title\":\"小猪\",\"flag\":0,\"orderby\":1,\"type\":1},{\"title\":\"袜子\",\"flag\":0,\"orderby\":2,\"type\":12},{\"title\":\"抱枕\",\"flag\":0,\"orderby\":3,\"type\":123},{\"title\":\"拖鞋\",\"flag\":0,\"orderby\":4,\"type\":1234}]";

        JSONObject obj = null;
        try {
            obj = JSONUtil.parseObj(json);
            System.out.println(obj.toString());
        } catch (Exception e) {
            log.error("error","JSON字符串格式错误");
            System.out.println(log.getName());
            System.gc();
        }
    }

    public static void textDBQuery(){
        try {
            List<Entity> list = SqlRunner.create().findAll("t_banner");
            System.out.println(list);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void textDBUpdate(){
        try {
            List<Entity> list = SqlRunner.create().findAll("t_banner");
            System.out.println(list);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
