package com.souche.db.aop;


import com.souche.db.annotation.Validate;
import com.souche.db.tool.ValidateTools;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;


@Aspect
@Component
@Order
public class ValidateAspect {
	
	@Pointcut("@annotation(com.souche.db.annotation.Validate)")
	public void execute() {
	}


	@Before("execute()")
	public void doExecute(JoinPoint point) {
		MethodSignature ms = (MethodSignature) point.getSignature();
		Method method = ms.getMethod();
		Object[] params = point.getArgs();
		if (params == null || params.length == 0) {
			return;
		}
		Annotation[][] paramAnnotations = method.getParameterAnnotations();
		if (paramAnnotations == null || paramAnnotations.length == 0) {
			return;
		}
		for (int i = 0; i < paramAnnotations.length; i++) {
			Annotation[] annotations = paramAnnotations[i];
			if (annotations == null || annotations.length == 0) {
				continue;
			}
			for (Annotation annotation : annotations) {
				if (annotation instanceof Validate) {
					Validate validate = (Validate) annotation;
					ValidateTools.validate(params[i], validate);
				}
			}
		}
	}

}
