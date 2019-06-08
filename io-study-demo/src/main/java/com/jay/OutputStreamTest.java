package com.jay;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

/**
 * 基于字节的I/O写操作
 * Created by xiang.wei on 2019/6/8
 *
 * @author xiang.wei
 */
public class OutputStreamTest {
    public static void main(String[] args) throws IOException {
//        实际写入的文件 /Volumes/Develop/JavaTempCode/io-study-demo/target/classes/outputTest.txt
        File file = new File(OutputStreamTest.class.getResource("/outputTest.txt").getFile());
        if (!file.exists()) {
            file.createNewFile();
        }
        writeStringToFile1(file);

    }

    /**
     * 使用FileOutputStream
     * @param file
     * @throws IOException
     */
    public static void  writeStringToFile1(File file) throws IOException {
        FileOutputStream fos = new FileOutputStream(file);
        try {
            fos.write("www.jay".getBytes());
            fos.flush();
        } finally {
            if (fos != null) {
                fos.close();
            }
        }
    }

    /**
     * 使用PrintStream写入
     * @param file
     * @throws FileNotFoundException
     */
    public static void writeStringToFile2(File file) throws FileNotFoundException {
        PrintStream printStream = null;
        try {
            printStream = new PrintStream(new FileOutputStream(file));
            printStream.append("你好");
            printStream.append("java");
        } finally {
            if (printStream != null) {
                printStream.close();
            }
        }
    }

    public static void writeStringTOFile3(File file) {

    }
}
