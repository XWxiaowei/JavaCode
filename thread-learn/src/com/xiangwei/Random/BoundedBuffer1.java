package com.xiangwei.Random;

import java.util.Random;

public class BoundedBuffer1<T> {

	 private Object[] objs=new Object[100];  
	    private int length;  
	    private int putIndex=0;//��ָ��  
	    private int getIndex=0;//ȡָ��  
	    /** 
	     * ���Ԫ�أ���ͷ��β���ٷ�����ͷ��β 
	     * @param t 
	     */  
	    public synchronized void put(T t)  
	    {  
	        //����Ѿ������ˣ��͵ȴ���  
	        while(length==objs.length)//���N���߳�������ȴ��� ����һ���̱߳����Ѻ�ִ������Ĵ��룬35��this.notify�����ǻ���ȡ�߳�ȡ���ݣ�����ʵ���ܻ��Ѵ��̡߳�  
	        {  
	            try {  
	                this.wait();  
	            } catch (InterruptedException e) {  
	                // TODO Auto-generated catch block  
	                e.printStackTrace();  
	            }  
	        }  
	        objs[putIndex]=t; //�ڶ�β����Ԫ��  
	        length++;  //���ȼ�1��  
	        putIndex++;  
	        if(putIndex==objs.length)  
	        {  
	            //ע�ⲻ�Ƿ����˲Ŵ���ʼ���ţ����Ǵ��ָ�뵽��β���ٴ�ͷ��ʼ��  
	            putIndex=0;  
	        }  
	        this.notify();  
	          
	    }  
	    /** 
	     * ȡԪ�أ���ͷ��βȡ������˷����� 
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
	                    synchronized (bb) { //�����synchronizedֻ��Ϊ���ö�ȡ���ݺʹ�ӡ���ݱ��������ԣ�����ʾ����  
	                        Integer data=bb.get();  
	                        System.out.println(Thread.currentThread().getName()+"  ��ȡԪ��------   "+data);  
	                    }  
	                      
	                }  
	            }  
	        };  
	        Runnable putRun=new Runnable() {  
	              
	            @Override  
	            public void run() {  
	                for(int i=0;i<10;i++)  
	                {  
	                    synchronized (bb) {//�����synchronizedֻ��Ϊ���ô�����ݺʹ�ӡ���ݱ��������ԣ�����ʾ����  
	                        Integer data=new Random().nextInt(100);  
	                        bb.put(data);  
	                        System.out.println(Thread.currentThread().getName()+"  ����---------------------------   "+data);  
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
