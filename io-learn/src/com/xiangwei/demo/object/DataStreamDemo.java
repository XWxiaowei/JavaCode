package com.xiangwei.demo.object;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;

public class DataStreamDemo {

	public static void main(String[] args) throws IOException {
		Member[] members={
			new Member("张三", 14),
			new Member("李四", 15),
			new Member("王五", 16)
		};
		args=new String[10];
		args[0]="D:/Test/Member.txt";
		try {
			DataOutputStream dataOutputStream =new DataOutputStream(new FileOutputStream(args[0]));
			for (Member member : members) {
				 //写入UTF字符串  
				dataOutputStream.writeUTF(member.getName());
				 //写入int数据  
				dataOutputStream.writeInt(member.getAge());
			}
			 //所有数据至目的地  
			dataOutputStream.flush();
			//关闭流
			dataOutputStream.close();
			
			DataInputStream dataInputStream=new DataInputStream(new FileInputStream(args[0]));
			//读取数据并还原对象
			for (int i = 0; i < members.length; i++) {
				String name=dataInputStream.readUTF();
				int age=dataInputStream.readInt();
				members[i]=new Member(name, age);
			}
			//关闭流
			dataInputStream.close();
			for (Member member : members) {
//				System.out.printf("%s\t%d%n",member.getName(),member.getAge());
				System.out.println(member.getName()+" "+member.getAge());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
