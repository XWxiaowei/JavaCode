package com.xiangwei.callable;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FutureAndCallable3 {
	/**
	 * 使用ExecutorService的submit(Callable c)方法
	 * 
	 * @param args
	 * @throws ExecutionException 
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService executorService = Executors.newFixedThreadPool(3);
		CompletionService<Integer> cs = new ExecutorCompletionService<Integer>(executorService);
		for (int i = 0; i < 10; i++) {
			final int j = i;
			cs.submit(new Callable<Integer>() {
				@Override
				public Integer call() throws Exception {
					int time = new Random().nextInt(500);
					Thread.sleep(time);
					return j;
				}
			});
		}
	     System.out.println("---------------------------"); 
	     for (int i = 0; i < 10; i++) {
			int a=cs.take().get();
			System.out.println(a);
		}
	     executorService.shutdown();
	}

}
