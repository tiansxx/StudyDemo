package com.tian.proxy;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CglibProxy implements MethodInterceptor {

	private Enhancer enhancer = new Enhancer();
	
	@SuppressWarnings("rawtypes")
	public Object getProxy(Class clazz) {
		enhancer.setSuperclass(clazz);
		enhancer.setCallback(this);
		return enhancer.create();
	}
	
	@Override
	public Object intercept(Object object, Method method, Object[] args,
			MethodProxy methodProxy) throws Throwable {
		
		System.out.println("==========before");
		Object invokeSuper = methodProxy.invokeSuper(object, args);
		System.out.println("==========after");
		return invokeSuper;
	}

}
