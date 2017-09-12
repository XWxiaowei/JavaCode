package com.jay.otherThread;

/**
 * 面试题测试：  6. 你如何实现这样一个功能，第一行输出###，换行，第二行输出$$$$,换行，交替输出10次
 * Created by xiang.wei on 2017/9/2
 */
public class ThreadTest {
    private static boolean flag = false;

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("#########");
                }
            },"A").start();
             new Thread(new Runnable() {
                 @Override
                 public void run() {
                     System.out.println("$$$$$$$$$");
                 }
             },"B").start();
        }
    }
}
