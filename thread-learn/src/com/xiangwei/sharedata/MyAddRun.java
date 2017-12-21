package com.xiangwei.sharedata;

public class MyAddRun implements Runnable {

	@Override
	public void run() {
		for (int j = 0; j < 20; j++) {
			Calculate.addOne();
		}
	}

}
