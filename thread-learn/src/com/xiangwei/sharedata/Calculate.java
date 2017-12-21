package com.xiangwei.sharedata;

public class Calculate {
	private static int i;

	public synchronized static void addOne() {
//		for (int j = 0; j < 20; j++) {
			i++;
			System.out.println(Thread.currentThread().getName() + i);
//		}

	}

	public synchronized static void subOne() {
//		for (int j = 0; j < 20; j++) {
			i--;
			System.out.println(Thread.currentThread().getName() + i);
//		}
	}

}
