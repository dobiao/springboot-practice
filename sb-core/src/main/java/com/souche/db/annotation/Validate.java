package com.souche.db.annotation;

import java.lang.annotation.*;

/**
 * 请在spring 容器中使用
 * 拦截com.souche下的包
 * @author cealiy
 */
@Inherited
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD,ElementType.PARAMETER,ElementType.METHOD})
public @interface Validate {
	
	/**
	 * 会判断对象是否为null,字符串是否是空字符串,collection是否为空
	 * @return
	 */
	public boolean require() default true;
	
	
	public String range() default "";
	
	/**
	 * 自定义校验方法
	 * 返回类型为布尔值
	 * 如com.XXXXX.XXXXXXXX.validateAddress
	 * @return
	 */
	public String userDefinedMethod() default "";
	
	
	public String failMessage() default "填写的信息有误";
	
	 /**
     * 字符串长度校验，均包括两边界
     * 例如 [0,1]表示0到1
     * 例如 [0,]表示大于等于0
     * 例如 [,9]表示小于等于9
     * @return
     */
    public String length() default "";
    
    /**
     * 正则表达式
     * @return
     */
    public String reg() default "";
}
