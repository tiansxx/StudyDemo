package com.tian.proxy;

public class ProxyMain {

	public static void main(String[] args) {
		HelloImpl hello = new HelloImpl();
		jdkProxy(hello);
		cglibProxy();
	}
	
	static void jdkProxy(HelloImpl hello) {
		JDKProxy proxy = new JDKProxy(hello);
		Hello proxyHello = (Hello) proxy.getProxy();
		proxyHello.hello();
	}
	
	static void cglibProxy() {
		CglibProxy proxy = new CglibProxy();
		SayHello target = (SayHello) proxy.getProxy(SayHello.class);
		target.hello();
	}
	
	
}
