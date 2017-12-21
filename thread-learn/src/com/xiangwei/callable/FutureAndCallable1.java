package com.xiangwei.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class FutureAndCallable1 {
    /** 
     * ʹ��FutureTask��Callable 
     * @param args 
     * @throws ExecutionException 
     * @throws InterruptedException 
     */  
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		 //FutureTaskʵ����Runnalbe�ӿڣ����Կ�����������Thread.  
        //FutureTaskʵ����Callable�ӿڣ�����ͨ��get��ȡ�̷߳���ֵ  
		FutureTask<String> futureTask=new FutureTask<String>(new Callable<String>() {
			@Override
			public String call() throws Exception {
				Thread.sleep(2000);
				return "hello";
			}
		});
		new Thread(futureTask).start();
		System.out.println("�߳̿�ʼ----------------");
		System.out.println(futureTask.get());
	}

}
