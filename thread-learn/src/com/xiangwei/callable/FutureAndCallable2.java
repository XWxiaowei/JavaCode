package com.xiangwei.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureAndCallable2 {
	 /** 
     * 使用ExecutorService的submit(Callable c)方法 
     * @param args 
     */  
    public static void main(String[] args)throws Exception  {  
        ExecutorService executorService=Executors.newFixedThreadPool(3);  
        Future<String> future=executorService.submit(new Callable<String>() {  
            @Override  
            public String call() throws Exception {  
                Thread.sleep(3000);  
                return "hello";  
            }  
        });  
        System.out.println("--------");  
        System.out.println(future.get());  
    }  
  
}
