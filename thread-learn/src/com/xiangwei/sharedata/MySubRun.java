package com.xiangwei.sharedata;

public class MySubRun implements Runnable {

	@Override
	public void run() {
		for (int j = 0; j < 20; j++) {
			Calculate.subOne();
		}
	}

}
