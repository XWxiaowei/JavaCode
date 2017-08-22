package com.jay.otherThread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by xiang.wei on 2017/8/22
 * 该程序用来模拟发送命令与执行命令，主线程代表指挥官，新建3个线程代表战士，战士一直等待着指挥官下达命令，
 * 若指挥官没有下达命令，则战士们都必须等待。一旦命令下达，战士们都去执行自己的任务，
 * 指挥官处于等待状态，战士们任务执行完毕则报告给
 * 指挥官，指挥官则结束等待。
 */
public class CountdownLatchTest {
    final static ExecutorService exec = Executors.newCachedThreadPool();//创建一个线程池
    final static CountDownLatch cdOrder = new CountDownLatch(1);//指挥官命令，只有一个指挥官
    final static CountDownLatch cdAnswer = new CountDownLatch(3); //战士命令，有三个战士

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println("线程" + Thread.currentThread().getName() + "正准备接受命令！");
                        cdOrder.await();//战士在等待
                        System.out.println("线程" + Thread.currentThread().getName() + "已接受命令！");
                        Thread.sleep((long) Math.random() * 1000);
                        System.out.println("线程" + Thread.currentThread().getName() + "已完成命令！");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        cdAnswer.countDown(); //任务执行完毕，返回给指挥官
                    }
                }
            };
            exec.submit(runnable);
        }
        //指挥官发布命令
        try {
            System.out.println("线程" + Thread.currentThread().getName() +
                    "即将发布命令");
            cdOrder.countDown();
            System.out.println("线程" + Thread.currentThread().getName() +
                    "已发送命令，正在等待结果");
            cdAnswer.await();//指挥官等待任务完成
            System.out.println("线程" + Thread.currentThread().getName() + "已经收到任务完成信号！");

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
        }
        exec.shutdown();
    }
}
