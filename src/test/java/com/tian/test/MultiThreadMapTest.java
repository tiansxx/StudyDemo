package com.tian.test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class MultiThreadMapTest {
	
//	public static Map<String, String> map = new ConcurrentHashMap<String, String>();
	public static Map<String, String> map = new HashMap<String, String>();
	
	public static void main(String[] args) {
		Task t1 = new Task();
		Task t2 = new Task();
		new Thread(t1).start();
		new Thread(t2).start();
		Iterator<Entry<String, String>> iterator = map.entrySet().iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
	
	static class Task implements Runnable {

		@Override
		public void run() {
			for (int i = 0; i < 1000; i++) {
				map.put(Thread.currentThread() + "-" + i, i + "");
			}
		}
		
	}
	
}
