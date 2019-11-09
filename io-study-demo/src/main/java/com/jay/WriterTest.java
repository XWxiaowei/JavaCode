package com.jay;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 基于字符的I/O写操作
 * Created by xiang.wei on 2019/6/8
 *
 * @author xiang.wei
 */
public class WriterTest {
    public static void main(String[] args) throws IOException {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(WriterTest.class.getResource("/outputTest.txt").getFile());
//            writeStringToFile1(fileWriter);
            writeStringToFile2(fileWriter);
        } catch (IOException e) {
            if (fileWriter != null) {
                fileWriter.close();
            }
        }

    }

    /**
     * 使用BufferedWriter写入
     * @param file
     * @throws IOException
     */
    public static void writeStringToFile1(FileWriter file) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(file);
        bufferedWriter.append("bufferedWriter");
        bufferedWriter.append("测试2111");
        bufferedWriter.close();
    }

    /**
     * 使用PrintWriter写入
     * @param fileWriter
     * @throws IOException
     */
    public static void writeStringToFile2(FileWriter fileWriter) throws IOException {
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.append("printWriter");
        printWriter.append("实验");
        printWriter.close();
    }
}
