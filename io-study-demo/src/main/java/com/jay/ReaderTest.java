package com.jay;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * 基于字符的I/O读操作
 * Created by xiang.wei on 2019/6/8
 *
 * @author xiang.wei
 */
public class ReaderTest {
    public static void main(String[] args) throws IOException {
        String fileName = ReaderTest.class.getResource("/inputTest.txt").getFile();
        readFileToString1(fileName);
//        readFileToString2(fileName);
    }

    /**
     *
     * @param fileName
     * @throws IOException
     */
    public static void readFileToString1(String fileName ) throws IOException {
        File file = new File(fileName);
        FileReader fileReader = new FileReader(file);
        int length = Integer.valueOf(String.valueOf(file.length()));
        char[] chars = new char[length];
        StringBuilder str = new StringBuilder();
        try {
            int data;
            while ((data=fileReader.read(chars))>0) {
                System.out.println("读取到的字符是="+data);
                str.append(chars);
            }
            System.out.println("读取到的结果："+str.toString());
        } finally {
            if (fileReader != null) {
                fileReader.close();
            }
        }
    }

    /**
     * InputStreamReader+BufferedReader读取字符串 ，
     * InputStreamReader类是从字节流到字符流的桥梁，按行读对于要处理的格式化数据是一种读取的好方式
     * @param fileName
     * @throws IOException
     */
    public static void readFileToString2(String fileName) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
        try {
            StringBuilder stringBuilder = new StringBuilder();
            String data = null;
            while ((data = bufferedReader.readLine()) != null) {
                stringBuilder.append(data);
            }
            System.out.println("读取到的结果："+stringBuilder.toString());
        } finally {
            if (bufferedReader != null) {
                bufferedReader.close();
            }
        }
    }
}
