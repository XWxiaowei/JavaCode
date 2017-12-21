package com.xiangwei.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedThreadPoolTest {
	public static void main(String[] args) {
		ExecutorService threadPool = Executors.newCachedThreadPool();// �̳߳صĴ�С�����ִ�е���������̬����
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
						System.out.println("��" + taskID + "������ĵ�" + j + "��ִ��");
					}
				}
			});

		}
		threadPool.shutdown();// ����ִ����Ϲر��̳߳�
	}
}
