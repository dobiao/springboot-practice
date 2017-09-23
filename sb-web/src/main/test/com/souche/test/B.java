package com.souche.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by dubiao on 2017/9/11.
 */
public class B {

    public static void main(String[] args) {
        List<String> stringArrayList = new ArrayList<String>();
        stringArrayList.add("A");
        stringArrayList.add("B");
        stringArrayList.add("C");
        stringArrayList.add("D");
        stringArrayList.add("E");
        stringArrayList.add("F");


        List<String> newList = stringArrayList.subList(0, 3);

        System.out.println(stringArrayList);
        System.out.println(newList);

        newList.set(0, "a");
        System.out.println(stringArrayList);
        System.out.println(newList);

        Collections.shuffle(stringArrayList);

        System.out.println(stringArrayList);



    }

}
