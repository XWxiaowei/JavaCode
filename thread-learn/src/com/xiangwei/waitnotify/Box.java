package com.xiangwei.waitnotify;

import java.util.ArrayList;
import java.util.List;



/**
 * 盛放热狗的盒子 
 * 功能：数据缓存区，容量为10 
 * 说明：将不同线程（生产者和消费者）对数据的处理放在同一个类（数据缓存区）中， 
 * 这样要同步的方法就可以通过共享数据（此例中的list和count（即list.size））的临界条件来决定执行哪个方法 
 * @author xiangwei
 *
 */
public class Box {
	private List<HotDog> hotDogList;//存放的热狗
	private int count;//盒中的热狗数量
	
	public List<HotDog> getHotDogList() {
		return hotDogList;
	}
	public void setHotDogList(List<HotDog> hotDogList) {
		this.hotDogList = hotDogList;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	/**
	 * 生产
	 * @param cookerName
	 * @throws Exception
	 */
	public synchronized void cook(String cookerName) throws Exception{
		//当盒中热狗的数量为10时，厨师休息
		while (count==10) {
			this.wait();
		}
		HotDog hotDog=new HotDog();
		if (hotDogList==null) {
			hotDogList=new ArrayList<HotDog>();
		}
		 hotDogList.add(hotDog);
		 count++;
		 System.out.println(cookerName+" 做了一个热狗，盘子总一共-----------   "+count); 
		 this.notifyAll();//唤醒其他线程
		
	}
	/**
	 * 售卖
	 * @param saleName
	 * @throws InterruptedException
	 */
	public synchronized void sale(String salerName) throws InterruptedException{
		while (count==0) {
			this.wait();
		}
			hotDogList.remove(0);
			count--;
		 System.out.println(salerName+" 卖出去一个热狗，盘子总一共---------------------------------------------------------------   "+count);  
	        this.notifyAll();//唤醒其他线程，cook或sale  
	}
}
