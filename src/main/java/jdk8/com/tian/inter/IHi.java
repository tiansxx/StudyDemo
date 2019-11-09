package jdk8.com.tian.inter;

public interface IHi {
	default void hello() {
		System.out.println("IHi hello");
	}
}
