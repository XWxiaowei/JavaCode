package com.jay.otherThread;

/**
 * Created by xiang.wei on 2017/9/2
 */
public class ThreadTest1 {
    private static boolean flag = false;

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            if (!flag) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("#########");
                        flag = true;
                    }
                }, "A").start();
            }
            if (flag) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("$$$$$$$$$");
                        flag = false;
                    }
                }, "B").start();
            }
        }
    }
}
