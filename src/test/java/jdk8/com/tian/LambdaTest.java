package jdk8.com.tian;

public class LambdaTest {

	public static void main(String[] args) {
		
		new LambdaTest().hello();
		
//		print(s -> System.out.println(s), "Hello World");
	}
	
	void hello() {
		Runnable runnable = () -> System.out.println(this);
		new Thread(runnable).start();
		runnable.run();
		
		new Runnable() {
			
			@Override
			public void run() {
				System.out.println(this);
			}
		};
		new Thread(runnable).start();
		
	}
	
	static void print(IHello hello, String s) {
		hello.hello(s);
	}
}
