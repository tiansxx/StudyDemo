package com.tian.concurrent;

import java.util.Arrays;
import java.util.concurrent.locks.ReentrantLock;

public class CopyOnWriteMain {

	public static void main(String[] args) {
		CopyOnWriteList<String> demo = new CopyOnWriteList<>();
		demo.add("hello");
		demo.get(0);
		demo.get(0);
		
		Object[] array = demo.getArray();
		array[0] = "world";
		System.out.println(demo.get(0));
		
	}
	
	static class CopyOnWriteList<E> {
		
		private final ReentrantLock lock = new ReentrantLock();
		
		private volatile Object[] array;
		
		public CopyOnWriteList() {
			setArray(new Object[0]);
		}

		public E get(int i) {
			return get(getArray(), i);
		}
		
		@SuppressWarnings("unchecked")
		public E get(Object[] a, int i) {
			System.out.println("Got object: " + a);
			return (E) a[i];
		}
		
		public void add(E e) {
			final ReentrantLock lock = this.lock;
			lock.lock();
			try {
				Object[] elements = getArray();
				System.out.println("Add object: " + elements);
				int len = elements.length;
				Object[] newElements = Arrays.copyOf(elements, len + 1);
				newElements[len] = e;
				setArray(newElements);
			} finally {
				lock.unlock();
			}
		}
		
		public Object[] getArray() {
			return array;
		}

		public void setArray(Object[] a) {
			this.array = a;
		}
		
		
	}
}
