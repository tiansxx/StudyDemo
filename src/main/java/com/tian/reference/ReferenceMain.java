package com.tian.reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

/**
 * 
 * @author tian
 */

public class ReferenceMain {
	
	public static void main(String[] args) {
		/*
		* 被包装成SoftReference的对象.
		* 程序中没有这些对象的强引用那么在JVM还没有out of memory的时候就不会回收,也就不会执行finalize()方法。 
        */  
		SoftReference<RefDemo> softRef = new SoftReference<ReferenceMain.RefDemo>(new RefDemo("soft demo1"));
		
		/*
		 * WeakReference中封装的对象.
		 * 在没有强引用的时候,gc会将它们都进行标记表示可以被回收,在被回收之前,对象会执行finalize()方法
		 */
		WeakReference<RefDemo> weakRef = new WeakReference<ReferenceMain.RefDemo>(new RefDemo("weak demo2"));
		System.out.println("before gc weak:" + weakRef.get());
		
		/**
		 * PhantomReference必需和ReferenceQueue联合使用.
		 * 当垃圾回收器准备回收一个对象时,如果发现它还有虚引用，就会在回收对象的内存之前，把这个虚引用加入到与之关联的引用队列中。
		 * 程序可以通过判断引用队列中是 否已经加入了虚引用，来了解被引用的对象是否将要被垃圾回收。
		 * 程序如果发现某个虚引用已经被加入到引用队列，那么就可以在所引用的对象的内存被回收之前采取必要的行动
		 */
		ReferenceQueue<RefDemo> rq = new ReferenceQueue<>();
		PhantomReference<RefDemo> phantomRef = new PhantomReference<ReferenceMain.RefDemo>(new RefDemo("phantom demo3"), rq);
		System.out.println("before gc phantom:" + phantomRef.get());
		
		System.gc();
		
		System.out.println("after gc weak:" + weakRef.get());
	}
	
	static class RefDemo {
		
		private String desc;
		
		public RefDemo(String desc) {
			this.desc = desc;
		}
		
		@Override
		public String toString() {
			return "RefDemo [desc=" + desc + "]";
		}

		@Override
		protected void finalize() throws Throwable {
			System.out.println("Finalize: " + desc);
		}
	}
}
