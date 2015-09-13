package com.tian.classes.inner;

/**
 * 
 * @author lenovo
 *
 * 内部类只在当前类可见,可访问外部类的静态与非静态成员
 * 
 */

public class InnerOuter {
	
	int i = 1;
	static int j = 2;
	
	public class Inner {
//		内部类(非静态嵌套类不能有静态变量)
//		static char c1 = 'a';
		char c2 = 'b';
		
		public void printInner() {
			System.out.println(i);
			System.out.println(j);
			printOuter();
			staticPrintOuter();
		}
	}
	
	public void printOuter() { }
	public static void staticPrintOuter() { }

}
