package com.xiangwei;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * ArrayBlockingQueue是阻塞队列接口BlockingQueue的一种实现。
 * 
 * 它的读有三种情况：1.如果读不到立即返回空，2.如果读不到等待直到返回结果（或超时，抛异常），3.如果读不到数据抛出异常
 * 
 * 相对应的，1.容器满了无法写入直接返回false，2.等待，直到可以写入（或超时，抛异常），3.无法写入直接抛出异常。
 * 
 * @author Administrator
 *
 */
public class BlockingQueueTest {

	public static void main(String[] args) {
		final BlockingQueue queue = new ArrayBlockingQueue<>(3);
		for (int i = 0; i < 2; i++) {
			new Thread() {
				public void run() {
					while (true) {
						try {
							Thread.sleep((long) (Math.random() * 1000));
							System.out.println(Thread.currentThread().getName() + "准备放数据!");
							queue.put(1);
							System.out.println(
									Thread.currentThread().getName() + "已经放了数据，" + "队列目前有" + queue.size() + "个数据");
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}.start();
		}
		new Thread(){
			public void run(){
				while (true) {
					try {
						Thread.sleep((long) (Math.random() * 1000));
						System.out.println(Thread.currentThread().getName() + "准备取数据!");
						queue.take();
						System.out.println(
								Thread.currentThread().getName() + "已经取了数据，" + "队列目前有" + queue.size() + "个数据");
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}.start();
	}

}
