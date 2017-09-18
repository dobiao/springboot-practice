package com.souche.db.aop;


import com.souche.db.annotation.PassportAccountIdHandler;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.thymeleaf.util.StringUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author wb-wsp312690
 * @Date 2017-9-15 17:28:57
 */
public class PassportAccountIdHandlerImpl {

    private static final Logger logger = LoggerFactory.getLogger(Logger.class);

    //@Resource
    //private PersonRemoteService personRemoteService;

    /**
     * 如何切入
     *
     * @param joinPoint
     * @return
     * @throws Throwable
     */
    public Object passportAccountIdHandler(ProceedingJoinPoint joinPoint) throws Throwable {
        // 获取方法信息
        MethodSignature ms = (MethodSignature) joinPoint.getSignature();
        Method method = ms.getMethod();

        // 获取请求参数列表
        Object[] args = joinPoint.getArgs();
        if (args == null && args.length < 1) {
            return args;
        }

        // 获取方法参数注解信息
        Annotation[][] annotationss = method.getParameterAnnotations();
        for (int i = 0; i < annotationss.length; i++) {
            for (int j = 0; j < annotationss[i].length; j++) {
                // 判断注解类型是否为指定的注解
                if (annotationss[i][j].annotationType().equals(PassportAccountIdHandler.class)) {
                    // 获取方法参数类型
                    Class<?>[] parameterTypes = method.getParameterTypes();
                    Class<?> clzz = parameterTypes[i];
                    // 判断是参数类型是否为基本类型或者是基本类型对应的包装类型，进行不同的处理。
                    if (clzz.isPrimitive() || this.isWrapClass(clzz)) {
                        if (clzz.getSimpleName().equals("Long")) {
                            args = this.getSimpleTypeParams(annotationss, args, i, j);
                        }
                    } else {
                        // 当参数类型为复杂类型时，必须指定需要绑定参数的名称，并且注解值不能为空
                        if (!((PassportAccountIdHandler) annotationss[i][j]).value().isEmpty()) {
                            args = this.getComplexTypeParam(clzz, args, ((PassportAccountIdHandler) annotationss[i][j]), i, j);
                        }
                    }
                }
            }
        }
        return joinPoint.proceed(args);
    }

    /**
     * 获取参数类型为简单类型的数据
     *
     * @param annotationss
     * @param args
     * @return
     */
    private Object[] getSimpleTypeParams(Annotation[][] annotationss, Object[] args, int i, int j) {
        // 判断该注解是否为我们需要处理的注解
        if (PassportAccountIdHandler.class.isInstance(annotationss[i][j])) {
            // 获取方法形参的具体参数
            Object param = args[i];
            try {
               /* PojoResult<Long> accountId = personRemoteService.getAccountIdByPassportAccountId(Long.valueOf(param.toString()));
                if (accountId != null && accountId.getContent() != null) {
                    args[i] = accountId.getContent();
                }*/
                args[i] = 11L;

            } catch (RuntimeException e) {
                logger.error("passportAccountId convert to accountId error", e);
            }
        }
        return args;
    }

    /**
     * 复杂类型的处理
     *
     * @param clzz
     * @param args
     * @param annotation
     * @param i
     * @param j
     * @return
     * @throws IllegalAccessException
     */
    private Object[] getComplexTypeParam(Class<?> clzz, Object[] args, PassportAccountIdHandler annotation, int i, int j) throws Exception {
        // 获取该方法中类型指定字段
        Field[] declaredFields = clzz.getDeclaredFields();
        for (Field field : declaredFields) {
            if (StringUtils.equals(field.getName(), annotation.value())) {
                field.setAccessible(true);
                Long account = (Long) field.get(args[i]);
                try {
                   /* PojoResult<Long> accountId = personRemoteService.getAccountIdByPassportAccountId(account);
                    if (accountId != null && accountId.getContent() != null) {
                        field.set(args[i], accountId.getContent());
                    }*/

                    field.set(args[i], 222L);
                } catch (Exception e) {
                    logger.error("passportAccountId convert to accountId error", e);
                }
            }
        }
        return args;
    }

    /**
     * 判断一个类型是否为包装类型
     *
     * @param clz
     * @return
     */

    private boolean isWrapClass(Class clz) {
        try {
            return ((Class) clz.getField("TYPE").get(null)).isPrimitive();
        } catch (Exception e) {
            return false;
        }
    }
}