package com.xiangwei.waitnotify;

public class Cooker implements Runnable{
	private String name;
	private Box box;
	
	public Cooker(String name, Box box) {
		super();
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
		try{
			for (int i = 0; i < 200; i++) {
				box.cook(name);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
