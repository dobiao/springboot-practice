package com.souche.test.validate;


import com.souche.db.service.ValidateReqWithSpring;
import com.souche.test.base.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by wangwenwei on 2017/8/21.
 */
public class ValidateTest extends BaseTest {


    @Autowired
    private ValidateReqWithSpring validateReqWithSpring;


    @Test
    public void validate() {
        validateReqWithSpring.validateLength("111", "222", "333");
    }
}
