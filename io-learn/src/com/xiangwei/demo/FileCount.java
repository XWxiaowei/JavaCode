package com.xiangwei.demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 字节流有输入和输出流，我们首先看输入流InputStream,我们首先解析一个例子（FileInputStream）。
 * @author xiangwei
 *
 */
public class FileCount {

	public static void main(String[] args) {
		int count=0;
		InputStream streamRead=null;
		try {
			streamRead=new FileInputStream(new File("D:/Test/首次引导 2016_8_3 21_25_51.mp4"));
	           /*1.new File()里面的文件地址也可以写成D:\\David\\Java\\java 高级进阶\\files\\tiger.jpg,前一个\是用来对后一个 
	           * 进行转换的，FileInputStream是有缓冲区的，所以用完之后必须关闭，否则可能导致内存占满，数据丢失。 
	          * 直接读不太可行，如果文件过大的话我们一步一步来，首先，上面的程序存在问题是，每读取一个自己我都要去用到FileInputStream，
	          * 我输出的结果是“---长度是： 64982 字节”，那么进行了64982次操作！可能想象如果文件十分庞大，这样的操作肯定会出大问题，
	          * 所以引出了缓冲区的概念。可以将streamReader.read()改成streamReader.read(byte[]b)此方法读取的字节数目等于字节数组的长度，
	          * 读取的数据被存储在字节数组中，返回读取的字节数，InputStream还有其他方法mark,reset,markSupported方法，例如：
	          */ 
			while (streamRead.read()!=-1) {
				count++;
			}
			System.out.println("长度为"+count+"字节");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				streamRead.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
