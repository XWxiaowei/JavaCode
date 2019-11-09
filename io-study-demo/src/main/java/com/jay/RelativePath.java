package com.jay;

/**
 * Created by xiang.wei on 2019/6/8
 *
 * @author xiang.wei
 */
public class RelativePath {
    public static void main(String[] args) {
//        方法一
        String fileName = ReaderTest.class.getResource("/inputTest.txt").getFile();
        System.out.println("*****方法一相对路径读取到的文件地址："+fileName);
//        方法二
        String fileName1 = Thread.currentThread().getContextClassLoader().getResource("inputTest.txt").getFile();
        System.out.println("*****方法二相对路径读取到的文件地址："+fileName1);
    }
}
