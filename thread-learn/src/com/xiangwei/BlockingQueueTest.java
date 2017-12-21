package com.xiangwei;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * ArrayBlockingQueue���������нӿ�BlockingQueue��һ��ʵ�֡�
 * 
 * ���Ķ������������1.����������������ؿգ�2.����������ȴ�ֱ�����ؽ������ʱ�����쳣����3.��������������׳��쳣
 * 
 * ���Ӧ�ģ�1.���������޷�д��ֱ�ӷ���false��2.�ȴ���ֱ������д�루��ʱ�����쳣����3.�޷�д��ֱ���׳��쳣��
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
							System.out.println(Thread.currentThread().getName() + "׼��������!");
							queue.put(1);
							System.out.println(
									Thread.currentThread().getName() + "�Ѿ��������ݣ�" + "����Ŀǰ��" + queue.size() + "������");
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
						System.out.println(Thread.currentThread().getName() + "׼��ȡ����!");
						queue.take();
						System.out.println(
								Thread.currentThread().getName() + "�Ѿ�ȡ�����ݣ�" + "����Ŀǰ��" + queue.size() + "������");
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}.start();
	}

}
