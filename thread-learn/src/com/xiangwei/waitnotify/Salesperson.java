package com.xiangwei.waitnotify;

public class Salesperson implements Runnable{
	private String name;
	private Box box;
	
	public Salesperson(String name, Box box) {
		this.name = name;
		this.box = box;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Box getBox() {
		return box;
	}

	public void setBox(Box box) {
		this.box = box;
	}

	@Override
	public void run() {
		try {  
            for(int i=0;i<200;i++)  
            {  
                box.sale(name);  
            }  
        } catch (Exception e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }  
	}
}
