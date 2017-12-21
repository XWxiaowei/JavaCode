package com.xiangwei.demo.object;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileConcatenate {

	public static void main(String[] args) {
		concennateFile(args);
	}

	public static void concennateFile(String... filename) {
		String str = null;
		// 构建该文件的输入流
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\Test\\copy2.txt"));
			for (String name : filename) {
				BufferedReader reader = new BufferedReader(new FileReader(name));
				while ((str=reader.readLine())!=null) {
					writer.write(str);
					writer.newLine();
				}
			}
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

}
