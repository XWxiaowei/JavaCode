package com.xiangwei;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * ���������timer��TimerTaskʵ��
 һ��ը��ÿ��2��ըһ�Σ���һ��ÿ��3��ըһ��
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