package com.jay.thread.chap03;

/**
 * Created by xiang.wei on 2017/8/17.
 */
public class NoVisibility {
    private static boolean ready=false;
    private static int number;

    private static class ReaderThread extends Thread {
        public void run() {
            while (!ready)
                Thread.yield();
            System.out.println(number);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new ReaderThread().start();
        Thread.sleep(1000);
        number = 42;
        ready = true;
    }
}
