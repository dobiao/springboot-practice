package com.souche.db.annotation;

import java.lang.annotation.*;

/**
 * 描述：加入查询结果的缓存
 * @author chhliu
 * 创建时间：2017年2月14日 下午10:30:00
 * @version 1.2.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface RedisCache {
    Class<?> type();//被代理类的全类名，在之后会做为redis hash 的key
}