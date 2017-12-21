package com.xiangwei.sharedata;

public class Demo2 {
	 /** 
     * @param args 
     */  
    public static void main(String[] args) {  
    	MyAddRun myAddRun=new MyAddRun();
    	MySubRun mySubRun=new MySubRun();
    	new Thread(myAddRun,"add--1111-----        ").start();
    	new Thread(myAddRun,"add--2222-----        ").start();
    	new Thread(mySubRun,"sub--1111-----        ").start();
    	new Thread(mySubRun,"sub--2222-----        ").start();
    }
    
}
