package com.xiangwei.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedThreadPoolTest {
	public static void main(String[] args) {
		ExecutorService threadPool = Executors.newCachedThreadPool();// 线程池的大小会根据执行的任务数动态分配
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
		threadPool.shutdown();// 任务执行完毕关闭线程池
	}
}
