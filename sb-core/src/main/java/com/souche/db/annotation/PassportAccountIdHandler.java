package com.souche.db.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 将PassportAccounId转换为accountId
 * 使用注解时：
 * 1，如果没有使用DTO对象来传入passportAccountId，
 * 那么必须指定passportAccountId在DTO中的字段名。如@PassportAccoutIdHandler("accountId")
 * 2，使用java基本类型或者对应的引用类型或String类型时，可以不用指定accountId的字段名。如@PassportAccoutIdHandler()
 *
 * @author wb-wsp312690
 * @Date 2017-9-16 12:26:39
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface PassportAccountIdHandler {
    String value() default "";
}