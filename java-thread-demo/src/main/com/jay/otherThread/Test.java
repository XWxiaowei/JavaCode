package com.jay.otherThread;

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

    }
}
