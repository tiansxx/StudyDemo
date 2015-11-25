package com.tian.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectMain {

	
	public static void main(String[] args) throws Exception {

		reflect1();
//		reflect2();
		
//		Basic basic = new Basic();
//		basic.print();
		
//		new ReflectMain().reflect();
		
	}
	
	public static void reflect1() throws Exception {
		Class<?> cls = Class.forName("com.tian.reflect.Basic");
		Object instance = cls.newInstance();
		System.out.println(instance.getClass());
//		java.lang.NoSuchMethodException: com.tian.reflect.Basic.print() ??  无法调用非公有方法
//		Method method = cls.getMethod("print");
//		method.setAccessible(true);
//		method.invoke(instance);
		
		Method method2 = cls.getMethod("print", String.class);
		method2.invoke(instance, "test");
		System.out.println(method2.getName());
	}
	
	public static void reflect2() throws NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {
		
		Class<?>[] argTypes = new Class[] {String.class};
		Method declaredMethod = Basic.class.getDeclaredMethod("print", argTypes);
		declaredMethod.setAccessible(true);
		declaredMethod.invoke(Basic.class.newInstance(), "hello");
		
	}
	
}
