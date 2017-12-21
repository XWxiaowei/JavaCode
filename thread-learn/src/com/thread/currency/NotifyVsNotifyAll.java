/*
 * Project: ThreadLearn
 * 
 * File Created at 2016年12月16日
 * 
 * Copyright 2016 CMCC Corporation Limited.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * ZYHY Company. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license.
 */
package com.thread.currency;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @Type NotifyVsNotifyAll.java
 * @Desc NotifyAll因某个特定锁而被调用时，只有等待这个锁的任务才会被唤醒
 * @author  xiang.wei
 * @date 2016年12月16日 上午7:26:22
 * @version v1.0
 */
class Blocker {
    synchronized void waitingCall() throws InterruptedException {
        while (!Thread.interrupted()) {
            wait();
            System.out.println(Thread.currentThread() + " ");
        }
    }

    synchronized void prod() {
        notify();
    }

    synchronized void prodAll() {
        notifyAll();
    }
}

class Task implements Runnable {
    static Blocker blocker = new Blocker();

    @Override
    public void run() {
        try {
            blocker.waitingCall();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

class Task2 implements Runnable {

    static Blocker blocker = new Blocker();

    @Override
    public void run() {
        try {
            blocker.waitingCall();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class NotifyVsNotifyAll {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            exec.execute(new Task());
            exec.execute(new Task2());
        }
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            boolean prod = true;

            @Override
            public void run() {
                if (prod) {
                    System.out.println("notify");
                    Task.blocker.prod();
                    prod = false;
                } else {
                    System.out.println("notifyAll");
                    Task.blocker.prodAll();
                    prod = true;
                }

            }
        }, 400, 400);
        TimeUnit.SECONDS.sleep(5);
        timer.cancel();
        System.out.println("\n Timer canceled");
        TimeUnit.MICROSECONDS.sleep(500);
        Task2.blocker.prodAll();
        TimeUnit.MICROSECONDS.sleep(500);
        System.out.println("\n shut down");
        exec.shutdownNow();
    }

}
