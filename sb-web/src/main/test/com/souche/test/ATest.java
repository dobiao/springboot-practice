package com.souche.test;

import com.souche.db.model.User;
import com.souche.db.utils.ObjectOutputTool;

/**
 * Created by dubiao on 2017/9/26.
 */
public class ATest {

    public static void main(String[] args) {

        System.out.println(
                new ObjectOutputTool().outObjPropertyString(new User()));


    }


}
