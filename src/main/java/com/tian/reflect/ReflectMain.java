package com.tian.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;

public class ReflectMain {

	
	public static void main(String[] args) throws Exception {

//		reflect1();
//		reflect2();
//		reflect3();
		reflect4();
		
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
	
	public static void reflect3() {
//		获取所有的public方法,包括在父类中定义的
		Method[] methods = ExtendedClass.class.getMethods();
		for (Method method : methods) {
			System.out.println(method.getName());
		}
	}
	
	/**
	 * Netty DirectByteBuf GC
	 */
	public static void reflect4()
	{
		 ByteBuffer direct = ByteBuffer.allocateDirect(1);
		 try {
			 Field cleanerField = direct.getClass().getDeclaredField("cleaner");
			 cleanerField.setAccessible(true);
			 Object cleaner = cleanerField.get(direct);
			 Method clean = cleaner.getClass().getDeclaredMethod("clean");
			 clean.invoke(cleaner);
		 } catch (Exception e) {
			 e.printStackTrace();
		}
	}
	
}
