package com.xiangwei.Random;

import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BoundedBuffer2<T> {
		private Object[] objs=new Object[100];
		private int length;
		private int putIndex=0;//��ָ��
		private int getIndex=0;//ȡָ��
		
		private Lock lock=new ReentrantLock();
		private Condition putcon=lock.newCondition();//������
		private Condition getcon=lock.newCondition();//ȡ����
		/**
		 * ���Ԫ�أ���ͷ��β���ڷ�����ͷ��β
		 * @param t
		 */
		public void put(T t){
			lock.lock();//����
			try {
				while (length==objs.length) { 
					//���N���߳�������ȴ��� ����һ���̱߳����Ѻ�ִ������Ĵ��룬35��this.notify�����ǻ���ȡ�߳�ȡ���ݣ�����ʵ���ܻ��Ѵ��̡߳�  
					try {
						putcon.await();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				objs[putIndex]=t;
				length++;
				putIndex++;
				
				if (putIndex==objs.length) {
					//ע�ⲻ�Ƿ����˲Ŵ���ʼ���ţ����Ǵ��ָ�뵽��β���ٴ�ͷ��ʼ��  
					putIndex=0;
				}
				getcon.signal();
				System.out.println(Thread.currentThread().getName()+"  ����---------------------------   "+t);  	
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				lock.unlock();
			}
			
		}
		/**
		 * ȡ��Ԫ�أ���ͷ��βȥ����˷���
		 * @param t
		 */
		public void get(){
			lock.lock();//����
			try {
				while (length==objs.length) { 
					//���N���߳�������ȴ��� ����һ���̱߳����Ѻ�ִ������Ĵ��룬35��this.notify�����ǻ���ȡ�߳�ȡ���ݣ�����ʵ���ܻ��Ѵ��̡߳�  
					try {
						getcon.await();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				T t=(T)objs[getIndex];
				length--;
				getIndex++;
				
				if (getIndex==objs.length) {
					//ע�ⲻ�Ƿ����˲Ŵ���ʼ���ţ����Ǵ��ָ�뵽��β���ٴ�ͷ��ʼ��  
					getIndex=0;
				}
				putcon.signal();
				System.out.println(Thread.currentThread().getName()+"  ȡ��---------------------------   "+t);  	
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				lock.unlock();
			}
			
		}

	      
	    public static void main(String[] args) {  
	        final BoundedBuffer2<Integer> bb=new BoundedBuffer2<Integer>();  
	        Runnable getRun=new Runnable() {  
	            @Override  
	            public void run() {  
	                for(int i=0;i<10;i++)  
	                {  
	                     bb.get();
	                }  
	            }  
	        };  
	        Runnable putRun=new Runnable() {  
	              
	            @Override  
	            public void run() {  
	                for(int i=0;i<10;i++)  
	                {  
	                	Integer data=new Random().nextInt(100);
	                	bb.put(data);
	                }  
	            }  
	        };  
	        System.out.println("***********************");  
	        for(int i=0;i<10;i++)  
	        {  
	            new Thread(getRun).start();  
	            new Thread(putRun).start();  
	        }  
	    }  
}
