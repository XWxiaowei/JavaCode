package com.jay.extend;

/**
 * Created by xiang.wei on 2018/1/29
 *
 * @author xiang.wei
 */
public class TripleTest {
    public static void main(String[] args) {
        int x=3;
        triple(x);
        System.out.println("计算后的x="+x);
    }

    public static void triple(int x) {
        x = 3 * x;
        System.out.println("经过运算的x="+x);
    }


}
