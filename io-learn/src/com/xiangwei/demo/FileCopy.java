package com.xiangwei.demo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileCopy {

	public static void main(String[] args) {
		byte[] buffer=new byte[512]; //����һ����Ϊ���������ֽ�����
		InputStream input=null;
		OutputStream out=null;
		int numberCount=0;
		try {
			input=new FileInputStream("D:/Test/�״����� 2016_8_3 21_25_51.mp4");
			out=new FileOutputStream("D:/Test/create1.txt");
			while ((numberCount=input.read(buffer))!=-1) { 
				//numberRead��Ŀ�����ڷ�ֹ���һ�ζ�ȡ���ֽ�С��buffer���ȣ�  
				out.write(buffer, 0, numberCount);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				input.close();
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
