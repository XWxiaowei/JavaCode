package com.xiangwei.demo;

import java.io.File;

public class FileExample {
	
	public static void main(String[] args) {
		File file=new File("D:/Test/create.txt");
		try {
			file.createNewFile();
				//���ҽ��������ھ��д˳���·����ָ�����Ƶ��ļ�ʱ�����ɷֵش���һ���µĿ��ļ���  
			System.out.println("�÷�����С"+file.getTotalSpace()/(1024*1024*1024)+"G"); 
			//�����ɴ˳���·������ʾ���ļ���Ŀ¼�����ơ�  
			file.mkdir(); //�����˳���·����ָ����Ŀ¼���������б��赫�����ڵĸ�Ŀ¼��
			System.out.println("�ļ���"+file.getName());
			System.out.println("�ļ���Ŀ¼�ַ���"+file.getParent());
			// ���ش˳���·������Ŀ¼��·�����ַ����������·����û��ָ����Ŀ¼���򷵻� null��  
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
