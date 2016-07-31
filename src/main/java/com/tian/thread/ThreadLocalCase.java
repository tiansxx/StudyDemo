package com.tian.thread;

public class ThreadLocalCase {

	private static ThreadLocal<Integer> tl;
	
	public ThreadLocalCase(ThreadLocal tl) {
		this.tl = tl;
	}
	
	public static int get() {  
		return ((Integer) (tl.get())).intValue();  
	}
	
	public static void set(int i) {
		tl.set(i);
	}

	static int nextSerialNum = 0;  

	public static void main(String[] args) {
		
		// The next serial number to be assigned  

		ThreadLocal<Integer> serialNum = new ThreadLocal<Integer>() {  
			protected synchronized Integer initialValue() {  
				return new Integer(nextSerialNum++);  
			}  
		};  
		
		ThreadLocalCase tlc1 = new ThreadLocalCase(serialNum);
		ThreadLocalCase tlc2 = new ThreadLocalCase(serialNum);
		
		tlc1.set(1);
		tlc2.set(2);
		
		System.out.println(tlc1.get());
		System.out.println(tlc2.get());
		
	}

}
