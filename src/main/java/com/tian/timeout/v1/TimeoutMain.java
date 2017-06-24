package com.tian.timeout.v1;

/**
 * 
 * @author tian
 */

public class TimeoutMain {

	public static void main(String[] args) {
		/**
		 * 使用TimeoutThread判断TaskThread线程执行是否超时
		 * 如果TimeoutThread执行完而TaskThread还未完成,表示TaskThread任务执行超时,抛出TimeoutException
		 */
		TimeoutThread timeoutThread = new TimeoutThread(500);
		TaskThread task = new TaskThread("Task", timeoutThread);
		
		task.start();
	}
	
}
