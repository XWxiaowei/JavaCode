package com.jay.thread.chap05;

import java.util.concurrent.CountDownLatch;

/**
 * Created by xiang.wei on 2017/8/23
 */
public class TestHarness {
    public long timeTasks(int nThreads, final Runnable task) throws InterruptedException {
        final CountDownLatch startGate = new CountDownLatch(1);
        final CountDownLatch endGate = new CountDownLatch(nThreads);
        for (int i = 0; i < nThreads; i++) {
            Thread t = new Thread() {
                public void run() {
                    try {
                        startGate.await();
                        task.run();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        endGate.countDown();
                    }
                }
            };
            t.start();
        }
        long startTime = System.nanoTime();
        startGate.countDown();
        endGate.await();
        long endTime = System.nanoTime();
        System.out.println(endTime-startTime);
        return endTime - startTime;
    }

    public static void main(String[] args) throws InterruptedException {
        TestHarness testHarness = new TestHarness();
        testHarness.timeTasks(10, new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep((long) (Math.random()*1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
