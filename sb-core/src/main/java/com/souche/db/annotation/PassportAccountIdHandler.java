package com.souche.db.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 将PassportAccounId转换为accountId
 * 使用注解时：
 *      1，如果没有使用DTO对象来传入passportAccountId，
 *          那么必须指定passportAccountId在DTO中的字段名。如@PassportAccoutId("accountId")
 *      2，使用java基本类型或者对应的引用类型时，可以不用指定accountId的字段名。如@PassportAccoutId()
 * 注意：
 *      在进行转换时，由于有的参数类型问题，可能无法转为Long，所以会导致转换失败，再使用DTO或者基本类型时，建议passportAccountId都使用Long类型。
 *
 * @author wb-wsp312690 2017-9-16 12:26:39
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface PassportAccountIdHandler {
    String value() default "";
}