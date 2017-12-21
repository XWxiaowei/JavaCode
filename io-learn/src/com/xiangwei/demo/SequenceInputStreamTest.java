package com.xiangwei.demo;

import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.util.Enumeration;
import java.util.Vector;

public class SequenceInputStreamTest {

	public static void main(String[] args) {
		doSequence();
	}
	private  static void doSequence(){
		//创建一个合并流对象
		SequenceInputStream sis=null;
		//创建输出流
		BufferedOutputStream bos=null;
		try {
			//构建流集合
			Vector<InputStream> vector=new Vector<>();
			vector.addElement(new FileInputStream("D:\\Test\\text1.txt"));
			vector.addElement(new FileInputStream("D:\\Test\\text2.txt"));
			vector.addElement(new FileInputStream("D:\\Test\\text3.txt"));
			Enumeration<InputStream> e = vector.elements(); 
			sis=new SequenceInputStream(e);
			bos=new BufferedOutputStream(new FileOutputStream("D:\\Test\\text4.txt"));
			
			//读写数据
			byte[] buffer=new byte[1024];
			int len=0;
			while ((len=sis.read(buffer))!=-1) {
				bos.write(buffer, 0, len);
				bos.flush();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				sis.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				bos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	} 
}
