package com.souche.test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by dubiao on 2017/9/19.
 */
public class BlockingQueueTest {

    public static void main(String[] args) {


        BlockingQueue<String> b = new ArrayBlockingQueue<String>(5);

        for (int i = 0; i < 10; i++)

        {
            b.add("sdsd");
        }

    }

}
