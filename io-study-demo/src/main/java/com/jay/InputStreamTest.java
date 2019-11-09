package com.jay;

import java.io.FileInputStream;
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
        String fileName = InputStreamTest.class.getResource("/inputTest.txt").getFile();
//        readString1(fileName);
        readString2(fileName);
    }

    /**
     * 以字节为单位读取文件，常用于读二进制文件，如图片、声音、影像等文件。
     * 当然也是可以读字符串的。
     *
     * @param fileName
     */
    public static void readString1(String fileName) throws IOException {
//        FileInputStream 用于读取诸如图像数据之类的原始字节流，读取字符流，请使用FileReader
        InputStream is = new FileInputStream(fileName);
        StringBuilder stringBuilder;
        try {
            stringBuilder = new StringBuilder();
            byte[] bytes = new byte[1024];
            while (is.read(bytes) != -1) {
                stringBuilder.append(bytes);
            }
        } finally {
            if (is != null) {
                is.close();
            }
        }
        System.out.println("读取到的结果：" + stringBuilder.toString());
    }

    /**
     * 按字节读取字符串,一次性读取完
     * @param fileName
     * @throws IOException
     */
    public static void readString2(String fileName) throws IOException {
        InputStream inputStream = new FileInputStream(fileName);
        try {
            // size  为字串的长度 ，这里一次性读完
            byte[] bytes = new byte[inputStream.available()];
            inputStream.read(bytes);
            System.out.println("读取到的结果是："+new String(bytes,"UTF-8"));
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }

    }
}
