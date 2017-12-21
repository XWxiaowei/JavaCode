package com.xiangwei.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class FutureAndCallable1 {
    /** 
     * 使用FutureTask和Callable 
     * @param args 
     * @throws ExecutionException 
     * @throws InterruptedException 
     */  
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		 //FutureTask实现了Runnalbe接口，所以可以用来构造Thread.  
        //FutureTask实现了Callable接口，可以通过get获取线程返回值  
		FutureTask<String> futureTask=new FutureTask<String>(new Callable<String>() {
			@Override
			public String call() throws Exception {
				Thread.sleep(2000);
				return "hello";
			}
		});
		new Thread(futureTask).start();
		System.out.println("线程开始----------------");
		System.out.println(futureTask.get());
	}

}
