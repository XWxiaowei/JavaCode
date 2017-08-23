package com.jay.thread.chap05;

import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by xiang.wei on 2017/8/23
 */
public class VectorTest {
    final static CountDownLatch cdOrder = new CountDownLatch(1);//指挥官命令，只有一个指挥官
    final static CountDownLatch cdAnswer = new CountDownLatch(1000);//士兵

    public static Object getList(Vector list) throws InterruptedException {
        int lastIndex = list.size() - 1;
        return list.get(lastIndex);
    }

    public static void deleteLast(Vector list) throws InterruptedException {
        int lastIndex = list.size() - 1;
        list.remove(lastIndex);
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        Vector<String> stringVc = new Vector<>();
        stringVc.add("1");
        stringVc.add("2");
        for (int i = 0; i < 1000; i++) {
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println("线程"+Thread.currentThread().getName()+"准备调用getList");
                        cdOrder.await();
                        System.out.println("线程"+Thread.currentThread().getName()+"调用getList");
                        VectorTest.getList(stringVc);
                    } catch (InterruptedException e) {
                        System.out.println(e.getMessage());
                    } finally {
                        cdAnswer.countDown();
                    }

                }
            };

            Runnable runnable1 = new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println("线程"+Thread.currentThread().getName()+"准备调用deleteLast");
                        cdOrder.await();
                        System.out.println("线程"+Thread.currentThread().getName()+"调用deleteLast");
                        VectorTest.deleteLast(stringVc);
                    } catch (InterruptedException e) {
                        System.out.println(e.getMessage());
                    } finally {
                        cdAnswer.countDown();
                    }
                }
            };
            exec.submit(runnable);
            exec.submit(runnable1);

        }
        try {
            cdOrder.countDown();
            cdAnswer.await();
            System.out.println("测试结束");
            exec.shutdown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
