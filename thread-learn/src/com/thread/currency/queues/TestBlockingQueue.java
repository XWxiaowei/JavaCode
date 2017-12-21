/*
F* Project: ThreadLearn
 * 
 * File Created at 2016年12月15日
 * 
 * Copyright 2016 CMCC Corporation Limited.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * ZYHY Company. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license.
 */
package com.thread.currency.queues;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.SynchronousQueue;

import com.thread.currency.LiftOff;

/**
 * @Type TestBlockingQueue.java
 * @Desc 
 * @author  xiang.wei
 * @date 2016年12月15日 下午5:01:27
 * @version 
 */
class LiffOffRunner implements Runnable {
    private BlockingQueue<LiftOff> rockets;

    public LiffOffRunner(BlockingQueue<LiftOff> queue) {
        rockets = queue;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                LiftOff rocket = rockets.take();
                rocket.run();
            }
        } catch (Exception e) {
            System.out.println("Waking from take()");
        }
    }

    public void add(LiftOff lo) {
        try {
            rockets.put(lo);
        } catch (Exception e) {
            System.out.println("Interrupt during put()");
        }
    }
}

public class TestBlockingQueue {
    static void getkey() {
        try {
            new BufferedReader(new InputStreamReader(System.in)).readLine();
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    static void getKey(String message) {
        System.out.println(message);
        getkey();
    }

    static void test(String msg, BlockingQueue<LiftOff> queue) {
        System.out.println(msg);
        LiffOffRunner runner = new LiffOffRunner(queue);
        Thread t = new Thread(runner);
        t.start();
        for (int i = 0; i < 5; i++) {
            runner.add(new LiftOff(5));
        }
        getKey("Press 'Enter'(" + msg + ") ");
        t.interrupt();
        System.out.println("Finished " + msg + "test");
    }

    public static void main(String[] args) {
        test("LinkedBlockingQueue", new LinkedBlockingDeque<LiftOff>());
        test("ArrayBlockingQueue", new ArrayBlockingQueue<LiftOff>(3));
        test("SynchronousQueue", new SynchronousQueue<LiftOff>());
    }
}
