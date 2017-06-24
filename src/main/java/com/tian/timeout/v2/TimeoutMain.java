package com.tian.timeout.v2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * 利用Future.get的阻塞机制判断超时
 * 
 * FutureTask底层也是另启一个线程,用于判断原有的线程执行是否超时
 * 
 * @author tian
 */

public class TimeoutMain {

	public static void main(String[] args) {
		
		ExecutorService threadPool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
		
		Future<String> future = threadPool.submit(new TimeTask());
		
		try {
			System.out.println(future.get(1001, TimeUnit.MILLISECONDS));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			threadPool.shutdown();
		}
		
	}
	
}
