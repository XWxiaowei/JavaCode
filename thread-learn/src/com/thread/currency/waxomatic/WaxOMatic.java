/*
 * Project: ThreadLearn
 * 
 * File Created at 2016年12月8日
 * 
 * Copyright 2016 CMCC Corporation Limited.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * ZYHY Company. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license.
 */
package com.thread.currency.waxomatic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @Type WaxOMatic.java
 * @Desc 
 * @author  xiang.wei
 * @date 2016年12月8日 下午3:42:04
 * @version 
 */
class Car {
    private boolean waxOn = false; //标志

    public synchronized void waxed() { //涂蜡完成
        waxOn = true;
        notifyAll();
    }

    public synchronized void buffed() { //抛光完成
        waxOn = false;
        notifyAll();
    }

    public synchronized void waitForWaxing() throws InterruptedException { //涂蜡中
        while (waxOn == false) {
            wait();
        }
    }

    public synchronized void waitForBuffing() throws InterruptedException { //抛光中
        while (waxOn == true) {
            wait();
        }
    }
}

class WaxOn implements Runnable {
    private Car car;

    public WaxOn(Car car) {
        super();
        this.car = car;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                System.out.println("涂蜡");
                TimeUnit.MILLISECONDS.sleep(200); //模拟涂蜡过程
                car.waxed();
                car.waitForBuffing();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("涂蜡完成");
    }
}

class WaxOff implements Runnable {
    private Car car;

    public WaxOff(Car car) {
        super();
        this.car = car;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                car.waitForWaxing();
                System.out.println("抛光");
                TimeUnit.MILLISECONDS.sleep(200);
                car.buffed();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("抛光完成");
    }
}

public class WaxOMatic {
    public static void main(String[] args) throws InterruptedException {
        Car car = new Car();
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new WaxOff(car));
        exec.execute(new WaxOn(car));
        TimeUnit.SECONDS.sleep(5);
        exec.shutdownNow();//中断所有任务
    }
}
