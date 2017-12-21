package com.xiangwei.waitnotify;

import java.util.ArrayList;
import java.util.List;



/**
 * ʢ���ȹ��ĺ��� 
 * ���ܣ����ݻ�����������Ϊ10 
 * ˵��������ͬ�̣߳������ߺ������ߣ������ݵĴ������ͬһ���ࣨ���ݻ��������У� 
 * ����Ҫͬ���ķ����Ϳ���ͨ���������ݣ������е�list��count����list.size�������ٽ�����������ִ���ĸ����� 
 * @author xiangwei
 *
 */
public class Box {
	private List<HotDog> hotDogList;//��ŵ��ȹ�
	private int count;//���е��ȹ�����
	
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
	 * ����
	 * @param cookerName
	 * @throws Exception
	 */
	public synchronized void cook(String cookerName) throws Exception{
		//�������ȹ�������Ϊ10ʱ����ʦ��Ϣ
		while (count==10) {
			this.wait();
		}
		HotDog hotDog=new HotDog();
		if (hotDogList==null) {
			hotDogList=new ArrayList<HotDog>();
		}
		 hotDogList.add(hotDog);
		 count++;
		 System.out.println(cookerName+" ����һ���ȹ���������һ��-----------   "+count); 
		 this.notifyAll();//���������߳�
		
	}
	/**
	 * ����
	 * @param saleName
	 * @throws InterruptedException
	 */
	public synchronized void sale(String salerName) throws InterruptedException{
		while (count==0) {
			this.wait();
		}
			hotDogList.remove(0);
			count--;
		 System.out.println(salerName+" ����ȥһ���ȹ���������һ��---------------------------------------------------------------   "+count);  
	        this.notifyAll();//���������̣߳�cook��sale  
	}
}
