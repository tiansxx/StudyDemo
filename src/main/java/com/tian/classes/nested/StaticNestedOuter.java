package com.tian.classes.nested;

/**
 * 静态嵌套类,可以访问外部类静态成员,无法访问非静态成员
 * 规则与静态方法不能访问实例变量类似
 * @author lenovo
 *
 */

public class StaticNestedOuter {
	int i = 1;
	static int j = 2;
	
//	static nested class
	public static class StaticNested {
		static char c1 = 'a';
		char c2 = 'a';
		
		public void printNested() {
			
//			静态嵌套类不能访问外部类的非静态成员
//			System.out.println(i);	
//			printOuter();
			
			System.out.println(j);
		}
	}
	
	public void printOuter() {
		
	}

}
