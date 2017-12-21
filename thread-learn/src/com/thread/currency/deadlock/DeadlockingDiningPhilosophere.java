/*
 * Project: ThreadLearn
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
package com.thread.currency.deadlock;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @Type DeadlockingDiningPhilosophere.java
 * @Desc 
 * @author  xiang.wei
 * @date 2016年12月15日 下午3:33:01
 * @version 
 */
public class DeadlockingDiningPhilosophere {

    public static void main(String[] args) throws InterruptedException, IOException {
        int ponder = 5;
        if (args.length > 0) {
            ponder = Integer.parseInt(args[0]);
        }
        int size = 5;
        if (args.length > 1) {
            size = Integer.parseInt(args[1]);
        }
        ExecutorService exec = Executors.newCachedThreadPool();
        Chopstick[] sticks = new Chopstick[size];
        for (int i = 0; i < size; i++) {
            sticks[i] = new Chopstick();
        }
        for (int i = 0; i < size; i++) {
//            sticks[(i + 1) % size]
            exec.execute(new Philosopher(sticks[i], sticks[(i + 1) % size], i, ponder));
        }
        if (args.length == 3 && args[2].equals("timeOut")) {
            TimeUnit.SECONDS.sleep(5);
        } else {
            System.out.println("Press 'Enter' to quit");
            System.in.read();
        }
        exec.shutdown();
    }

}
