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

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @Type Philosopher.java
 * @Desc 
 * 5个哲学家，5根筷子，他们围坐在桌子周边，每人之间放一根筷子。
 * 当哲学家就餐的时候必须同时得到左边和右边的筷子。首先拿起右边的筷子
 * @author  xiang.wei
 * @date 2016年12月15日 下午3:00:36
 * @version 
 */
public class Philosopher implements Runnable {
    private Chopstick left;
    private Chopstick right;
    private final int id;
    private final int ponderFactor;
    private Random rand = new Random(47);

    public Philosopher(Chopstick left, Chopstick right, int id, int ponderFactor) {
        super();
        this.left = left;
        this.right = right;
        this.id = id;
        this.ponderFactor = ponderFactor;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                System.out.println(this + " " + "thinking");
                pause(); //思考
                System.out.println(this + " " + "grabbing right");
                right.take();
                System.out.println(this + " " + "grabbing left");
                left.take();
                System.out.println(this + " " + "eating");
                pause();
                right.drop();
                left.drop();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void pause() {
        if (ponderFactor == 0) {
            return;
        }
        try {
            TimeUnit.MILLISECONDS.sleep(rand.nextInt(ponderFactor) * 250);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Philosopher"+id;
    }
}
