package com.tian.proxy;

import net.sf.cglib.proxy.Proxy;

public class ProxyMain {

	public static void main(String[] args) {
//		HelloImpl hello = new HelloImpl();
//		jdkProxy(hello);
		cglibProxy();
	}
	
	static void jdkProxy(HelloImpl hello) {
		JDKProxy proxy = new JDKProxy(hello);
		Object obj = proxy.getProxy();
//		System.out.println(proxyHello);
		System.out.println("Is a proxy class ? " + Proxy.isProxyClass(obj.getClass()));
		Hello proxyHello = (Hello) obj;
		proxyHello.hello();
		
		ProxyUtils.generateClassFile(hello.getClass(), "HelloImplProxy");
	}
	
	static void cglibProxy() {
		CglibProxy proxy = new CglibProxy();
		SayHello target = (SayHello) proxy.getProxy(SayHello.class);
		target.hello();
		
		ProxyUtils.generateClassFile(target.getClass(), "SayHelloCglibProxy");
	}
	
	
}
