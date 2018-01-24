package com.jay.lambda;


import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by xiang.wei on 2018/1/24
 * 按照字符串的长度来排序
 * @author xiang.wei
 */
public class LengthComparator implements Comparator<String> {

    @Override
    public int compare(String first, String second) {
        return first.length()-second.length();
    }

    public static void main(String[] args) {
        //1. 普通写法
        String[] strings= {"Zhangsan","lisi","wan"};
        Arrays.sort(strings, new LengthComparator());
        for (String string : strings) {
            System.out.println("普通"+string);
        }
        //Lambda 写法1
        Arrays.sort(strings,(String first,String second)->{
            return first.length()-second.length();
        });
        //lambda 写法2
        Comparator<String> comp = (first, second) -> {
            return first.length() - second.length();
        };
        Arrays.sort(strings, comp);
        //lambda 写法3
        Comparator<String> comp2 = Comparator.comparingInt(String::length);
        Arrays.sort(strings, comp2);
    }
}

