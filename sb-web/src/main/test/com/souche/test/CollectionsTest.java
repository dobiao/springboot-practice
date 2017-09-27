package com.souche.test;

import com.google.common.collect.Maps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;

/**
 * Created by dubiao on 2017/9/11.
 */
public class CollectionsTest {

    public static void main(String[] args) {
        List<String> stringArrayList = new ArrayList<String>();
        stringArrayList.add("IfelseTest");
        stringArrayList.add("CollectionsTest");
        stringArrayList.add("C");
        stringArrayList.add("D");
        stringArrayList.add("E");
        stringArrayList.add("F1");


        List<String> newList = stringArrayList.subList(0, 3);

        System.out.println(stringArrayList);
        System.out.println(newList);

        newList.set(0, "a");
        System.out.println(stringArrayList);
        System.out.println(newList);

        Collections.shuffle(stringArrayList);

        System.out.println(stringArrayList);

        Boolean.valueOf(true);

        Maps.newHashMap();


    }

}
