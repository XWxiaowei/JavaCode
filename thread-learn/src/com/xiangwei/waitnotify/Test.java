package com.xiangwei.waitnotify;

public class Test {
	 public static void main(String[] args) {  
		 	Box box=new Box();  
	        Cooker cooker1=new Cooker("����",box);  
	        Cooker cooker2=new Cooker("����",box);  
	        Salesperson saler1=new Salesperson("С��", box);  
	        Salesperson saler2=new Salesperson("С��", box);  
	        new Thread(cooker1).start();  
	        new Thread(cooker2).start();  
	        new Thread(saler1).start();  
	        new Thread(saler2).start(); 
	        
	 }
}
