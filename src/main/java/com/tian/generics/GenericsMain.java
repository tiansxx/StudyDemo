package com.tian.generics;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 
 * @author lenovo
 *
 * 泛型
 * 确保编译时不出现类型转化错误,在运行时就不会有错
 */

public class GenericsMain {

	public static void main(String[] args) {
		List<Object> ls = new ArrayList<Object>();
		ls.add("1");
		ls.add(1);
//		printList(ls);
	}
	
	static void printList(List<?> list) {
		Iterator<?> iter = list.iterator();
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}
	}
	
	/**
	 * 只能读取数据
	 * 
	 * ? extends Fruit,默认所有Fruit的子类
	 * 如果先往list里加入Apple,再加了Orange,取出来的时候,无法判断取出的是Apple还是Orange,报错,与泛型理念不符,
	 * 禁止add
	 */
	static void producerExtends() {
		List<? extends Fruit> list = new ArrayList<>();
		list.get(0);
	}
	
	/**
	 * 只能添加数据
	 * ? super Apple, 默认所有Apple父类
	 * 如果往list里加了大Apple,再加了小Apple,取出来的时候,无法确定转成大Apple还是小Apple,报错
	 * 禁止get(???)
	 */
	static void consumerSuper() {
		List<? super Apple> list = new ArrayList<>();
		list.add(new Apple());
		list.get(0);
	}
	
}
