package jdk8.com.tian.inter;

import java.util.function.Supplier;

public interface IHello {

	// 接口默认方法
	default void hello() {
		System.out.println("This is IHello.");
	}
	
	static void helloWorld() {
		System.out.println("Ihello :\t Hello World.");
	}
	
	static IHello create(Supplier<IHello> supplier) {
		return supplier.get();
	}
	
}
