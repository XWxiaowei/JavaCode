package com.jay;

import java.io.FileReader;
import java.io.IOException;

/**
 * Created by xiang.wei on 2019/6/8
 *  面向字符的I/O操作
 * @author xiang.wei
 */
public class ReaderTest {
    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader(ReaderTest.class.getResource("/inputTest.txt").getFile());
        int data;
        while ((data = fileReader.read()) != -1) {
            System.out.println(data);
        }
    }
}
