/*
 * Project: ThreadLearn
 * 
 * File Created at 2016年12月9日
 * 
 * Copyright 2016 CMCC Corporation Limited.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * ZYHY Company. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license.
 */
package com.thread.currency.Interrupt;

import java.util.concurrent.TimeUnit;

/**
 * @Type InterruptingIdiom.java
 * @Desc  检查中断
 * @author  xiang.wei
 * @date 2016年12月9日 下午12:35:41
 * @version 
 */
class NeedsCleanup {
    private final int id;

    public NeedsCleanup(int id) {
        super();
        this.id = id;
    }

    public void cleanup() {
        System.out.println("Cleaning up" + id);
    }
}

class Block3 implements Runnable {
    private volatile double d = 1.0;

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                //point 1
                NeedsCleanup n1 = new NeedsCleanup(1);
                try {
                    System.out.println("sleep");
                    TimeUnit.SECONDS.sleep(2);
                    //point2
                    NeedsCleanup n2 = new NeedsCleanup(2);
                    try {
                        System.out.println("Calculating");
                        for (int i = 0; i < 250000; i++) {
                            d = d + (Math.PI + Math.E) / d;
                        }
                        System.out.println("完成循环");
                    } finally {
                        n2.cleanup();
                    }
                } finally {
                    n1.cleanup();
                }
            }
            System.out.println("退出测试");
        } catch (Exception e) {
            System.out.println("退出中断");
        }
    }

}

public class InterruptingIdiom {

    public static void main(String[] args) throws NumberFormatException, InterruptedException {
/*        if (args.length != 1) {
            System.out.println("usage:java Interrpting");
            System.exit(1);
        }*/
        Thread t = new Thread(new Block3());
        t.start();
        TimeUnit.MILLISECONDS.sleep(new Integer(100));
        t.interrupt();
    }

}
