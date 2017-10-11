package com.souche.test.validate;


import com.souche.db.annotation.Validate;
import com.souche.db.tool.ValidateTools;
import org.junit.Before;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * Created by wangwenwei on 2017/8/21.
 */
public class ValidateToolsTest {

    private Validate validateLength;

    private Validate validateRequire;

    private Validate validateUserDefined;

    @Before
    public void init() {
        ValidateReq validateReq = new ValidateReq();
        Class<? extends ValidateReq> c = validateReq.getClass();

        Method method = null;
        try {
            method = c.getMethod("validateLength", new Class[]{String.class, String.class, String.class});
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        Annotation[][] paramAnnotations = method.getParameterAnnotations();
        validateLength = (Validate) paramAnnotations[0][0];
        validateRequire = (Validate) paramAnnotations[1][0];
        validateUserDefined = (Validate) paramAnnotations[2][0];

    }


    @Test
    public void validateLength1() {
        ValidateTools.validate("18850338440X", validateLength);
    }


    @Test
    public void validateLength2() {
        ValidateTools.validate("18838440", validateLength);
    }

    @Test
    public void validateRequire1() {
        ValidateTools.validate(null, validateRequire);
    }

    @Test
    public void validateRequire2() {
        ValidateTools.validate("", validateRequire);
    }


    @Test
    public void validateUserDefined1() {
        ValidateTools.validate("att", validateUserDefined);
    }

    @Test
    public void validateUserDefine2() {
        ValidateTools.validate("att1", validateUserDefined);
    }


}
