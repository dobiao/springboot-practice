package com.souche.test.model;

import lombok.Data;

/**
 * Created by dubiao on 2017/10/28.
 */
@Data
public class Student {

    private String name;
    private int age;
    private Long rate;

    public Student(String name, int ag, Long rate) {
        super();
        this.name = name;
        this.age = age;
        this.rate = rate;
    }

}
