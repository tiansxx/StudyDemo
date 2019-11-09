package jdk8.com.tian.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
/**
 * stream api : 集合、IO
 * @author tian
 *
 */
public class LambdaDemo {

	public static void main(String[] args) {
		
		List<String> list = Arrays.asList("c", "b", "a");
		
//		clazzInfo(list);
//		printList(list);
		
//		concat(list);
		
		String[] array = list.toArray(new String[0]);
		Arrays.sort(array, comparator());
		System.out.println(Arrays.toString(array));
	}
	
	static Comparator<String> comparator() {
		return (a, b) -> a.compareTo(b);
	}
	
	static void clazzInfo(List<String> list) {
		System.out.println(list.getClass());
		System.out.println(ArrayList.class);
		System.out.println(list instanceof ArrayList);
	}
	
	static void printList(List<String> list) {
		// < jdk8
		System.out.println("########");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		// jdk8
		System.out.println("######### java8");
		list.forEach(e -> System.out.println(e));
	}
	
	static void concat(List<String> list) {
		StringBuilder sbd = new StringBuilder();
		
		list.forEach(e -> sbd.append(e));
		System.out.println(sbd);
		
		sbd.setLength(0);
		list.stream().forEach(e -> sbd.append(e));
		System.out.println(sbd);
	}
	
}
