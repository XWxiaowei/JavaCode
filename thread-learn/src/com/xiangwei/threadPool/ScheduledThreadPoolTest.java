package com.xiangwei.threadPool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPoolTest {
	public static void main(String[] args) { 
		ScheduledExecutorService scheduledPool=Executors.newScheduledThreadPool(1);
		scheduledPool.schedule(new Runnable() {
			@Override
			public void run() {
				System.out.println("±¬Õ¨");
			}
		}, 5, TimeUnit.SECONDS);
		scheduledPool.scheduleAtFixedRate(new Runnable() {
			@Override
			public void run() {
				System.out.println("±¬Õ¨");
			}
		}, 5,2, TimeUnit.SECONDS);
	}
}
