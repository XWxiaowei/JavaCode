package com.xiangwei;

import java.io.IOException;
import java.io.StringReader;

public class MemoryInput {
	
	public static void main(String[] args) throws IOException {
	   StringReader in=new StringReader(BufferedInputFile.read("MemoryInput.java"));	
	   int c;
	   while ((c=in.read())!=-1) {
		System.out.println((char)c);
	}
	}

}
