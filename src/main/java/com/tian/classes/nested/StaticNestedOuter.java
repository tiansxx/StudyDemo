package com.tian.classes.nested;

/**
 * ��̬Ƕ����,���Է����ⲿ�ྲ̬��Ա,�޷����ʷǾ�̬��Ա
 * �����뾲̬�������ܷ���ʵ����������
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
			
//			��̬Ƕ���಻�ܷ����ⲿ��ķǾ�̬��Ա
//			System.out.println(i);	
//			printOuter();
			
			System.out.println(j);
		}
	}
	
	public void printOuter() {
		
	}

}
