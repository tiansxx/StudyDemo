package com.tian.jvm;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;
import java.util.List;

/**
 * jdk1.8 默认使用-XX:+UseParallelGC，吞吐量优先 => Parallel Scavenge + Serial Old
 * @author tian
 *
 */
public class GCDemo {
	
	private static final int _1M = 1024 * 1024;

	public static void main(String[] args) {
//		basicJvmInfo();
//		cmsGcLog();
		g1GcLog();
	}
	
	/**
	 * -XX:+PrintGCDetails -XX:+PrintHeapAtGC -XX:+PrintGCDateStamps -XX:+PrintGCApplicationStoppedTime -XX:+PrintCommandLineFlags
	 */
	static void basicJvmInfo() {
		MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();
		MemoryUsage heapMemoryUsage = memoryMXBean.getHeapMemoryUsage();
		System.out.println("Heap Info: \r\n" + heapMemoryUsage);
		
		List<String> inputArguments = ManagementFactory.getRuntimeMXBean().getInputArguments();
		System.out.println("Java options args: \r\n" + inputArguments);
		
	}
	
	/**
	 * -Xms8m -Xmx8m -Xmn2m -XX:+UseConcMarkSweepGC -XX:+PrintGCDetails -XX:+PrintGCDateStamps -XX:+PrintCommandLineFlags
	 */
	static void cmsGcLog() {
		byte[] bs1 = new byte[1 * _1M];
		byte[] bs2 = new byte[1 * _1M];
		byte[] bs3 = new byte[1 * _1M];
		byte[] bs4 = new byte[1 * _1M];
		byte[] bs5 = new byte[1 * _1M];
		byte[] bs6 = new byte[1 * _1M];
//		byte[] bs7 = new byte[2 * _1M];
		
	}
	
	/**
	 * -Xms8m -Xmx8m -Xmn2m -XX:+UseG1GC  -XX:+PrintGCDetails -XX:+PrintGCDateStamps -XX:+PrintCommandLineFlags
	 */
	static void g1GcLog() {
		byte[] bs1 = new byte[1 * _1M];
		byte[] bs2 = new byte[1 * _1M];
		byte[] bs3 = new byte[1 * _1M];
//		byte[] bs4 = new byte[1 * _1M];
//		byte[] bs5 = new byte[1 * _1M];
//		byte[] bs6 = new byte[1 * _1M];
//		byte[] bs7 = new byte[2 * _1M];
		
	}
}
