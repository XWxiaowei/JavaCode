package com.xiangwei.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadPoolTest {

	public static void main(String[] args) {
		// 创建一个有3个线程的线程池
		ExecutorService threadPool = Executors.newFixedThreadPool(3);
		for (int i = 1; i < 5; i++) {
			final int taskID = i;
			threadPool.execute(new Runnable() {
				
				@Override
				public void run() {
					for (int j = 1; j < 5; j++) {
						try {
							Thread.sleep(20);
						} catch (Exception e) {
							e.printStackTrace();
						}
						System.out.println("第" + taskID + "次任务的第" + j + "次执行");
					}
				}
			});
			
		}
		threadPool.shutdown();//任务执行完毕关闭线程池
	}

}
