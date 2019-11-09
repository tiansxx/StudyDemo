package jdk8.com.tian.inter;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Demo {

	public static void main(String[] args) {
		
		defaultMethod();
		
		functionalInterface();
		
		supplier();
		
		consumer();
		
		function();
		
		predicate();
		
	}
	
	static void defaultMethod() {
		new HelloService().hello();
		
		new HelloOverrideService().hello();
		
		IHello.helloWorld();
		
		new HelloImpl().hello();
	}
	
	static void supplier() {
		// ::	可用于访问类的构造方法，对象方法，静态方法
		IHello helloService = IHello.create(HelloService::new);
		helloService.hello();
		
		IHello helloOverrideService = IHello.create(HelloOverrideService::new);
		helloOverrideService.hello();
		
		
		//
		Supplier<IHello> supplier = new Supplier<IHello>() {

			@Override
			public IHello get() {
				return new HelloService();
			}
			
		};
		IHello create = IHello.create(supplier);
		create.hello();
		
		//
		Supplier<IHello> supplier2 = () -> new HelloOverrideService();
		IHello create2 = IHello.create(supplier2);
		create2.hello();
	}
	
	static void functionalInterface() {
		//函数接口	实例方法
		Converter<String, String> converter = new HelloService()::hi;
		System.out.println(converter.convert("functional interface"));
		
		//函数接口 静态方法
		Printer printer = IHello::helloWorld;
		printer.print();
	}
	
	static void consumer() {
		Consumer<String> consumer = p -> System.out.println(p);
		consumer.accept("Hello World");
	}
	
	static void function() {
		Function<Integer, Integer> func = p -> p * p;
		System.out.println(func.apply(10));
	}
	
	static void predicate() {
		Predicate<Integer> predicate = p -> p > 20;
		System.out.println(predicate.test(21));
	}
}
