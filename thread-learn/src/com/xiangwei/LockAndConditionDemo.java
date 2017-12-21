package com.xiangwei;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 实现1，2，3模块按顺序执行
 * 
 * @author XW
 * 
 */
public class LockAndConditionDemo {
	private Lock lock = new ReentrantLock();
	private int taskNo = 1; // 默认执行模块一
	private Condition c1 = lock.newCondition();
	private Condition c2 = lock.newCondition();
	private Condition c3 = lock.newCondition();

	public void task1() {
		try {
			lock.lock();
			while (taskNo != 1) {
				try {
					c1.await();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			System.out.println("task1执行");
			taskNo = 2;
			c2.signal();
		} finally {
			lock.unlock();
		}
	}

	public void task2() {
		try {
			lock.lock();
			while (taskNo != 2) {
				try {
					c2.await();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			System.out.println("task2执行22222222222222");
			taskNo = 3;
			c3.signal();
		} finally {
			lock.unlock();
		}
	}

	public void task3() {
		try {
			lock.lock();
			while (taskNo != 3) {
				try {
					c3.await();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			System.out.println("task3执行333333333333333333");
			taskNo = 1;
			c1.signal();
		} finally {
			lock.unlock();
		}
	}

	public static void main(String[] args) {
		final LockAndConditionDemo lockAndConditionDemo = new LockAndConditionDemo();
		Runnable run1 = new Runnable() {

			@Override
			public void run() {
				lockAndConditionDemo.task1();
			}
		};
		Runnable run2 = new Runnable() {

			@Override
			public void run() {
				lockAndConditionDemo.task2();
			}
		};
		Runnable run3 = new Runnable() {

			@Override
			public void run() {
				lockAndConditionDemo.task3();
			}
		};
		
		for (int i = 0; i < 10; i++) {
			new Thread(run1).start();
			new Thread(run2).start();
			new Thread(run3).start();
		}
	}

}
