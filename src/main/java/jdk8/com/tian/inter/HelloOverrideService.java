package jdk8.com.tian.inter;

public class HelloOverrideService implements IHello {

	@Override
	public void hello() {
//		IHello.super.hello();
		System.out.println("This is hello override service.");
	}
}
