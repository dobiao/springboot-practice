package com.souche.test;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

/**
 * Created by dubiao on 2017/9/20.
 */

public class GoogleMapTest {


    public static void main(String[] args) {


        Multimap<String, String> phoneBook = ArrayListMultimap.create();

        phoneBook.put("ss", "110");
        phoneBook.put("ss", "120");

        System.out.println(phoneBook.get("ss"));

    }
}
