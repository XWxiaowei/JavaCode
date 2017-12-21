package com.xiangwei;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 例：如何用timer和TimerTask实现
 一个炸弹每隔2秒炸一次，另一个每隔3秒炸一次
 * @author lenovo
 *
 */
public class TimerDemo {
	public static int count=0;
	 public static void main(String[] args) throws Exception{  
		 new Timer().schedule(new BoomTimeTask(), 2000);
		 while (true) {
			Thread.sleep(1000);
			System.out.println(new Date().getSeconds());
		}
	 }
}
class BoomTimeTask extends TimerTask{

	@Override
	public void run() {
		System.out.println("boom!..............................");
		TimerDemo.count++;
		new Timer().schedule(new BoomTimeTask(), TimerDemo.count%2==0?2000:3000);;
	}
	
}