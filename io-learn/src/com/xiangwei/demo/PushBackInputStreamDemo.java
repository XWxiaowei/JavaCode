package com.xiangwei.demo;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.PushbackInputStream;

public class PushBackInputStreamDemo {

	 public static void main(String[] args) throws IOException {  
		    String str = "hello,rollenholt";  
		    PushbackInputStream push = null; // ��������������  
		    ByteArrayInputStream bat = null; // �����ֽ�����������  
		    bat = new ByteArrayInputStream(str.getBytes());  
		    push = new PushbackInputStream(bat); // �������������󣬽������ֽ�����������  
		    int temp = 0;  
		    while ((temp = push.read()) != -1) { // push.read()���ֽڶ�ȡ�����temp�У������ȡ��ɷ���-1  
		       if (temp == ',') { // �ж϶�ȡ���Ƿ��Ƕ���  
		          push.unread(temp); //�ص�temp��λ��  
		          temp = push.read(); //���Ŷ�ȡ�ֽ�  
		          System.out.print("(����" + (char) temp + ") "); // ������˵��ַ�  
		       } else {  
		          System.out.print((char) temp); // ��������ַ�  
		       }  
		    }  
		}  

}
