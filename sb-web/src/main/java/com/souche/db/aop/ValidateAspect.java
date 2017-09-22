package com.souche.db.aop;

import com.souche.db.annotation.Validate;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * Created by dubiao on 2017/9/14.
 */
@Component
@Aspect
@Configuration
public class ValidateAspect {


    @Around("@annotation(validate)")// 定义注解类型的切点，只要方法上有该注解，都会匹配
    public Object before(ProceedingJoinPoint proceed, Validate validate) {
        System.out.println("ValidateAspect before method");
        Object result = null;
        if ("zxc".equals(validate.value())) {
            //将执行的目标方法最后一个参数修改,没有参数会报错,必须是基本类型
            String param = (String) proceed.getArgs()[proceed.getArgs().length - 1];
            proceed.getArgs()[proceed.getArgs().length - 1]= "被 ValidateAspect改变的值 " + param;
        }
        try {
            result = proceed.proceed(proceed.getArgs());
        }catch (Throwable e) {
            e.printStackTrace();
        }
        return result;
    }







}
