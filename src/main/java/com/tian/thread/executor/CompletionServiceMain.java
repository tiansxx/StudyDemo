package com.tian.thread.executor;

import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletionServiceMain {

	public static void main(String[] args) {
		
		ExecutorService exec = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
		ExecutorCompletionService<?> completionService = new ExecutorCompletionService<>(exec);
		
//		completionService.submit(task);
		
		
	}
}
