package com.jay.otherThread;

import java.util.ArrayList;

/**
 * Created by xiang.wei on 2017/8/17.
 */
public class Test extends Thread {
    public static void main(String[] args) throws InterruptedException {
        new Thread(new Runnable() {
            public void run() {
                System.out.println("1");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("2");

            }
        }).start();
        System.out.println("3");
        Thread.sleep(2000);
        System.out.println("4");

        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(1);
        for (Integer integer : integers) {
            System.out.println("当前值："+integer);
        }
    }
}
