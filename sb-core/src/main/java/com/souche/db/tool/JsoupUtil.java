package com.souche.db.tool;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

/**
 * Jsoup
 * @author wb-wsp312690
 * @date 2017-12-7 09:22:08
 */
public class JsoupUtil {

    public static void main(String[] args){
        try {
            Document document = Jsoup.connect("http://en.wikipedia.org/").get();
            System.out.println(document.title());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}