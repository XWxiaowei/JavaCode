package com.xiangwei.Random;

import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BoundedBuffer2<T> {
		private Object[] objs=new Object[100];
		private int length;
		private int putIndex=0;//存指针
		private int getIndex=0;//取指针
		
		private Lock lock=new ReentrantLock();
		private Condition putcon=lock.newCondition();//存条件
		private Condition getcon=lock.newCondition();//取条件
		/**
		 * 存放元素，从头到尾，在反复从头到尾
		 * @param t
		 */
		public void put(T t){
			lock.lock();//上锁
			try {
				while (length==objs.length) { 
					//如果N个线程在这儿等待， 其中一个线程被唤醒后，执行下面的代码，35行this.notify本意是唤醒取线程取数据，但其实可能唤醒存线程。  
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
					//注意不是放满了才从起始处放，而是存放指针到队尾了再从头开始。  
					putIndex=0;
				}
				getcon.signal();
				System.out.println(Thread.currentThread().getName()+"  放入---------------------------   "+t);  	
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				lock.unlock();
			}
			
		}
		/**
		 * 取出元素，从头到尾去，如此反复
		 * @param t
		 */
		public void get(){
			lock.lock();//上锁
			try {
				while (length==objs.length) { 
					//如果N个线程在这儿等待， 其中一个线程被唤醒后，执行下面的代码，35行this.notify本意是唤醒取线程取数据，但其实可能唤醒存线程。  
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
					//注意不是放满了才从起始处放，而是存放指针到队尾了再从头开始。  
					getIndex=0;
				}
				putcon.signal();
				System.out.println(Thread.currentThread().getName()+"  取出---------------------------   "+t);  	
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
