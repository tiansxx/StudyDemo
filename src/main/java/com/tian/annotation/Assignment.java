package com.tian.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//声明注解的保留策略，只有声明为RUNTIME的注解才可以在运行时通过反射API获得注解的信息
@Retention(RetentionPolicy.RUNTIME)
//@Retention(RetentionPolicy.CLASS)
//用来声明注解可以被添加在哪些类型的元素上
@Target(ElementType.TYPE)
public @interface Assignment {
	String assignee();
	int effort();
	double finished() default 0;
}
