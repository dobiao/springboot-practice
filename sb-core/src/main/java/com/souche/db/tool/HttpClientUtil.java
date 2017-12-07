package com.souche.db.tool;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

/**
 *  封装的HTTP工具类 TODO： 待完善
 * @author wb-wsp312690
 * @date 2017-12-6 16:45:13
 */
@Slf4j
public class HttpClientUtil {

    /**
     * 发送一个不带参数的GET请求
     * @param url
     * @return
     */
    public static String doGet(String url){
        return doGet(url, new HashMap<>(0));
    }

    /**
     * 发送一个带参数的GET请求
     * @param url
     * @return
     */
    public static String doGet(String url, HashMap<String, Object> params){
        StringBuffer param = new StringBuffer();
        int i = 0;
        for (String key : params.keySet()){
            if (i == 0){
                param.append("?");
            }else {
                param.append("&");
            }
            param.append(key).append("=").append(params.get(key));
            i++;
        }
        url += param;
        String result = null;
        HttpClient http = new DefaultHttpClient();
        try {
            HttpGet httpGet = new HttpGet(url);
            HttpResponse response = http.execute(httpGet);
            HttpEntity entity = response.getEntity();
            if (response.getStatusLine().getStatusCode() == 200 && entity != null){
                InputStream content = entity.getContent();
                result = IOUtils.toString(content, "UTF-8");
            }
            log.info("Execute http request erorrcode is :" + response.getStatusLine().getStatusCode());
        }catch (IOException e){
            log.error("Execute http request error!", e);
        }
        return result;
    }

}