package com.jay.other;

import java.util.ArrayList;

/**
 * Created by xiang.wei on 2017/9/9
 */
public class ForOrForeachTest {
    public static void main(String[] args) {
        String s = null;
        System.out.println("s=" + s);

        ArrayList<String> strings = new ArrayList<>();
        for (int i = 0; i < 10000000; i++) {
            strings.add("1");
            strings.add("2");
        }
        int j = 0;
        long startTime = System.currentTimeMillis();
        for (String string : strings) {
            j++;
        }
        System.out.println("foreach总用时：" + (System.currentTimeMillis() - startTime));
        startTime = System.currentTimeMillis();
        for (int i = 0; i < strings.size(); i++) {
            j++;
        }
        System.out.println("正序遍历总用时：" + (System.currentTimeMillis() - startTime));
        startTime = System.currentTimeMillis();
        for (int i = strings.size() - 1; i >= 0; i--) {
            j++;
        }
        System.out.println("倒序遍历总用时：" + (System.currentTimeMillis() - startTime));



    }
}
