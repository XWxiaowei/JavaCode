package com.jay.exceptions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 抛出异常伪代码
 * Created by xiang.wei on 2018/1/21
 *
 * @author xiang.wei
 */
public class FileInputStreamTest {
    public static void main(String[] args) throws FileNotFoundException {
//        FileInputStream in = new FileInputStream("test.log");
//        try {
//            //1
////        code that might throw exception
//            //2
//        } catch (IOException e) {
//           //3
//            //show error message
//            //4
//        }
//        finally {
//            //5
//            //in.close();
//        }
//        //6


        FileInputStream in = new FileInputStream("test.log");
        try {
            try {
//        code that might throw exception
            } finally {
                in.close();
            }
        } catch (IOException e) {
            //show error message
        }



    }
}
