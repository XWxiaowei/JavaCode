package com.jay;

import java.io.IOException;
import java.io.InputStream;

/**
 * 基于字节的I/O读操作
 * Created by xiang.wei on 2019/6/8
 *
 * @author xiang.wei
 */
public class InputStreamTest {
    public static void main(String[] args) throws IOException {
        InputStream inputStream =  InputStreamTest.class.getResourceAsStream("/inputTest.txt");
        try {
            int data;
            while ((data=inputStream.read()) != -1) {
                System.out.println(data);
            }
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }
}
