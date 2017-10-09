package com.souche.test;

import net.sf.oval.ConstraintViolation;
import net.sf.oval.Validator;
import net.sf.oval.constraint.Length;
import net.sf.oval.constraint.Min;

import java.util.List;

public class OvalTest {
    @Min(20)
    private int age;
    @Length(min = 6, max = 10)
    private String name;

    public static void main(String[] args) {
        OvalTest ovalTest = new OvalTest();
        ovalTest.age = 10;
        ovalTest.name = "kolor";

        Validator validator = new Validator();

        List<ConstraintViolation> ret = validator.validate(ovalTest);
        System.out.println(ret);
    }
}
