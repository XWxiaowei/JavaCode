package com.xiangwei.demo.object;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ObjectDemo {

	public static void main(String[] args) throws ClassNotFoundException {
		  ObjectOutputStream objectwriter=null;  
	      ObjectInputStream objectreader=null;  
		
	    try {
			objectwriter=new ObjectOutputStream(new FileOutputStream("D:/Test/Student.txt"));
			objectwriter.writeObject(new Student("张三", 12));
			objectwriter.writeObject(new Student("李四", 14));
			objectwriter.writeObject(new Student("王二", 14));
			objectreader=new ObjectInputStream(new FileInputStream("D:/Test/Student.txt"));
			
			for (int i = 0; i < 3; i++) {
				System.out.println(objectreader.readObject());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				objectreader.close();
				objectwriter.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}

class Student implements Serializable {
	private String name;
	private int age;
	
	public Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + "]";
	}

}
