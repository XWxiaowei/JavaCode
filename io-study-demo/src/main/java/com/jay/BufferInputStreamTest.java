package com.jay;

import java.io.BufferedInputStream;
import java.io.IOException;

/**
 * Created by xiang.wei on 2019/6/8
 *
 * @author xiang.wei
 */
public class BufferInputStreamTest {
    public static void main(String[] args) throws IOException {
        BufferedInputStream inputStream =  new BufferedInputStream(InputStreamTest.class.getResourceAsStream("/inputTest.txt"));
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
