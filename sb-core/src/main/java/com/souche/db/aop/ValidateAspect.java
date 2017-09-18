package com.souche.db.aop;

import com.souche.db.annotation.Validate;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * Created by dubiao on 2017/9/14.
 */
@Component
@Aspect
@Configuration
public class ValidateAspect {


    @Pointcut("@annotation(com.souche.db.annotation.Validate)")// 定义注解类型的切点，只要方法上有该注解，都会匹配
    public void before(JoinPoint joinPoint, Validate validate) {
        if (validate.value().equals("zxc")) {
            String param = (String) joinPoint.getArgs()[joinPoint.getArgs().length - 1];
            if (param.length() > 30) {
                try {
                    System.out.println(param);
                    System.out.println("ttttt");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }







}
