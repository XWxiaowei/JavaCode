package com.xiangwei.Random;

import java.util.Random;

public class BoundedBuffer1<T> {

	 private Object[] objs=new Object[100];  
	    private int length;  
	    private int putIndex=0;//存指针  
	    private int getIndex=0;//取指针  
	    /** 
	     * 存放元素，从头到尾，再反复从头到尾 
	     * @param t 
	     */  
	    public synchronized void put(T t)  
	    {  
	        //如果已经放满了，就等待。  
	        while(length==objs.length)//如果N个线程在这儿等待， 其中一个线程被唤醒后，执行下面的代码，35行this.notify本意是唤醒取线程取数据，但其实可能唤醒存线程。  
	        {  
	            try {  
	                this.wait();  
	            } catch (InterruptedException e) {  
	                // TODO Auto-generated catch block  
	                e.printStackTrace();  
	            }  
	        }  
	        objs[putIndex]=t; //在队尾插入元素  
	        length++;  //长度加1，  
	        putIndex++;  
	        if(putIndex==objs.length)  
	        {  
	            //注意不是放满了才从起始处放，而是存放指针到队尾了再从头开始。  
	            putIndex=0;  
	        }  
	        this.notify();  
	          
	    }  
	    /** 
	     * 取元素，从头到尾取，在如此反复。 
	     * @return 
	     */  
	    public synchronized T get()  
	    {  
	        while(length==0)  
	        {  
	            try {  
	                this.wait();  
	            } catch (InterruptedException e) {  
	                // TODO Auto-generated catch block  
	                e.printStackTrace();  
	            }  
	        }  
	        T t=(T) objs[getIndex];  
	        length--;  
	        getIndex++;  
	        if(getIndex==objs.length)  
	        {  
	            getIndex=0;  
	        }  
	        this.notify();  
	        return t;  
	    }  
	      
	    public static void main(String[] args) {  
	        final BoundedBuffer1<Integer> bb=new BoundedBuffer1<Integer>();  
	        Runnable getRun=new Runnable() {  
	            @Override  
	            public void run() {  
	                for(int i=0;i<10;i++)  
	                {  
	                    synchronized (bb) { //这里加synchronized只是为了让读取数据和打印数据保持完整性，做演示用用  
	                        Integer data=bb.get();  
	                        System.out.println(Thread.currentThread().getName()+"  读取元素------   "+data);  
	                    }  
	                      
	                }  
	            }  
	        };  
	        Runnable putRun=new Runnable() {  
	              
	            @Override  
	            public void run() {  
	                for(int i=0;i<10;i++)  
	                {  
	                    synchronized (bb) {//这里加synchronized只是为了让存放数据和打印数据保持完整性，做演示用用  
	                        Integer data=new Random().nextInt(100);  
	                        bb.put(data);  
	                        System.out.println(Thread.currentThread().getName()+"  放入---------------------------   "+data);  
	                    }  
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
