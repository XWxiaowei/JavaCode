package com.xiangwei.demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * �ֽ������������������������ȿ�������InputStream,�������Ƚ���һ�����ӣ�FileInputStream����
 * @author xiangwei
 *
 */
public class FileCount {

	public static void main(String[] args) {
		int count=0;
		InputStream streamRead=null;
		try {
			streamRead=new FileInputStream(new File("D:/Test/�״����� 2016_8_3 21_25_51.mp4"));
	           /*1.new File()������ļ���ַҲ����д��D:\\David\\Java\\java �߼�����\\files\\tiger.jpg,ǰһ��\�������Ժ�һ�� 
	           * ����ת���ģ�FileInputStream���л������ģ���������֮�����رգ�������ܵ����ڴ�ռ�������ݶ�ʧ�� 
	          * ֱ�Ӷ���̫���У�����ļ�����Ļ�����һ��һ���������ȣ�����ĳ�����������ǣ�ÿ��ȡһ���Լ��Ҷ�Ҫȥ�õ�FileInputStream��
	          * ������Ľ���ǡ�---�����ǣ� 64982 �ֽڡ�����ô������64982�β�����������������ļ�ʮ���Ӵ������Ĳ����϶���������⣬
	          * ���������˻������ĸ�����Խ�streamReader.read()�ĳ�streamReader.read(byte[]b)�˷�����ȡ���ֽ���Ŀ�����ֽ�����ĳ��ȣ�
	          * ��ȡ�����ݱ��洢���ֽ������У����ض�ȡ���ֽ�����InputStream������������mark,reset,markSupported���������磺
	          */ 
			while (streamRead.read()!=-1) {
				count++;
			}
			System.out.println("����Ϊ"+count+"�ֽ�");
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
