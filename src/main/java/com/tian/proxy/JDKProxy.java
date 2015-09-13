package com.tian.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JDKProxy implements InvocationHandler {
	private Object target;
	
	public JDKProxy(Object target) {
		this.target = target;
	}
	
//	execute the method of target object
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		System.out.println(proxy.getClass());
		System.out.println(method.getName());
//		System.out.println(args.toString());
		System.out.println("--------before execute----------");
		Object invoke = method.invoke(target, args);
		System.out.println("--------after execute----------");
		return invoke;
	}
	
//	Return the proxy object of target object, can only return the type of interface
	public Object getProxy() {
		Object obj = Proxy.newProxyInstance(target.getClass().getClassLoader(), 
				target.getClass().getInterfaces(), this);
		return obj;
	}

}
