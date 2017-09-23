package com.souche.db.aop;

import com.souche.db.annotation.MethodCache;
import com.souche.db.cache.CacheService;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;


/**
 * Created by dubiao on 2017/9/22.
 */
@Aspect
@Component
public class MethodCacheAspect {

    private static Logger logger = Logger.getLogger(MethodCacheAspect.class);
    private static final String KEY = "test";

    @Autowired
    private CacheService cacheService;

    /**
     * 搭配 AspectJ 指示器“@annotation()”可以使本切面成为某个注解的代理实现
     */
    @Around("@annotation(com.souche.db.annotation.MethodCache)")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        String cacheKey = getCacheKey(joinPoint);
        String s = cacheService.get(cacheKey);
        if (s != null) {

            //logger.info("cache hit，key [{}]", cacheKey);
            return s;
        } else {
            //logger.info("cache miss，key [{}]", cacheKey);
            Object result = joinPoint.proceed(joinPoint.getArgs());
            if (result == null) {
                //logger.error("fail to get data from source，key [{}]", cacheKey);
            } else {
                MethodCache methodCache = getAnnotation(joinPoint, MethodCache.class);
                cacheService.set(cacheKey, result.toString(), methodCache.expire());
            }
            return result;
        }
    }

    /**
     * 根据类名、方法名和参数值获取唯一的缓存键
     *
     * @return 格式为 "包名.类名.方法名.参数类型.参数值"，类似 "your.package.SomeService.getById(int).123"
     */
    private String getCacheKey(ProceedingJoinPoint joinPoint) {
        return String.format("%s.%s",
                joinPoint.getSignature().toString().split("\\s")[1], StringUtils.join(joinPoint.getArgs(), ","));
    }

    private <T extends Annotation> T getAnnotation(ProceedingJoinPoint jp, Class<T> clazz) {
        MethodSignature sign = (MethodSignature) jp.getSignature();
        Method method = sign.getMethod();
        return method.getAnnotation(clazz);
    }
}
