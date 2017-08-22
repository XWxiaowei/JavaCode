package com.jay.otherThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 利用AtoInteger计算线程数，再利用synchronize方法块阻塞一个线程，
 * 根据AtoInteger的判断，执行sleep。
 * Created by xiang.wei on 2017/8/22
 */
public class CountDownLatchTest1 implements Runnable {
    final AtomicInteger number = new AtomicInteger();
    volatile boolean bol = false;
    @Override
    public void run() {
        System.out.println(number.getAndIncrement());
        synchronized (this) {
            try {
                if (!bol) {
                    System.out.println(bol);
                    bol = true;
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("并发数量为："+number.intValue());
        }

    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        CountDownLatchTest1 test = new CountDownLatchTest1();
        for (int i = 0; i <10 ; i++) {
            exec.submit(test);
        }
        exec.shutdown();
    }
}
