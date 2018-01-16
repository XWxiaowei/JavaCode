package com.jay.other;

/**
 * Created by xiang.wei on 2017/9/17
 */
public class StringTest {
    public static void main(String[] args) {
        String greeting = "test1";
        String b = "test1";
//        length方法将返回采用UTF-16编码表示的给定字符串所需要的代码单元数量。
        System.out.println(greeting.length());
//        得到实际的长度，即码点数量
        int cpCount = greeting.codePointCount(0, greeting.length());
        System.out.println(cpCount);

        int[] ints = greeting.codePoints().toArray();
        for (int anInt : ints) {
            System.out.println(anInt);
        }
        //将一个码点数组转换为一个字符串
        String str = new String(ints, 0, ints.length);
        System.out.println(str);


//        string 常用方法练习
        String learn1 = "learn1";
        String learn1_temp = "Learn1";
        String learn2 = "learn2";
//        equal
        System.out.println("equals:" + learn1.equals(learn2));
//        equalsIgnoreCase
        System.out.println("equalsIgnoreCase:" + learn1.equalsIgnoreCase(learn1_temp));
        System.out.println("startsWith:" + learn1.startsWith("l"));
        System.out.println("endsWith:" + learn1.endsWith("1"));
//        返回与字符串str或代码点cp匹配的第一个子串的开始位置。这个位置从索引0或fromIndex开始计算。如果在原始串中不存在str,返回-1
        System.out.println("indexOf:" + learn1.indexOf("a"));
        System.out.println("lastIndexOf1:" + learn1.lastIndexOf("1"));
        System.out.println("lastIndexOf2:" + learn1.lastIndexOf("2"));
        System.out.println("length:" + learn1.length());

        System.out.println("substring(2):" + learn1.substring(2));
        System.out.println("substring(0,3)" + learn1.substring(0, 3));

        System.out.println("toUpperCase():" + learn1.toUpperCase());

        StringBuilder builder = new StringBuilder("121");
        String toString = builder.toString();

        Object object = new Object();
        object.toString();


        //hashCode
        String s = "OK";
        StringBuilder sb = new StringBuilder(s);
        System.out.println(s.hashCode() + " " + sb.hashCode());
        String t = new String("OK");
        StringBuilder tb = new StringBuilder(t);
        System.out.println(t.hashCode() + " " + tb.hashCode());
    }
}
