package jdk8.com.tian.inter;

public class HelloService implements IHello {
	
	public String hi(String msg) {
		return "hi " + msg;
	}
	
}
