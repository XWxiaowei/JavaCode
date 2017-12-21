package com.xiangwei;

public class SynchronizedDemo {
	public static void main(String[] args) {
		 final Print print = new Print();
		 for (int i = 0; i <100; i++) {
			new Thread(){
				public void run(){
					System.out.println("线程1启动");
					print.printName("huangfeihong");
				}
			}.start();
			new Thread(){
				public void run(){
					System.out.println("线程2启动");
					print.printName("zhangsanfeng");
				}
			}.start();
		}
	}
}
class Print{
	public void printName(String name){
		synchronized (this) {
			for (int i = 0; i < name.length(); i++) {
        		System.out.println(name.charAt(i));
			}
			 System.out.println(); 
		}
	}
}