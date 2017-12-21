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
package com.thread.currency.ToastOMatic;

import java.sql.Time;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

import javax.print.attribute.standard.Finishings;

/**
 * @Type ToastOMatic.java
 * @Desc 制作吐司的程序，有三道工序，一个制作吐司，一个给吐司抹黄油
 *另外一个就是在抹过黄油的吐司上涂果酱
 * @author  xiang.wei
 * @date 2016年12月15日 下午6:46:04
 * @version 
 */
class Toast {
    public enum Status {
        DRY,
        BUTTERED,
        JAMMED
    }

    private Status status = Status.DRY;
    private final int id;

    public Toast(int id) {
        this.id = id;
    }

    public void butter() {
        status = Status.BUTTERED;
    };

    public void jam() {
        status = Status.JAMMED;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Toast [status=" + status + ", id=" + id + "]";
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

}

class ToastQueue extends LinkedBlockingDeque<Toast> {
};

class Toaster implements Runnable {
    private ToastQueue toastQueue;
    private int count = 0;
    private Random rand = new Random(47);

    public Toaster(ToastQueue toastQueue) {
        super();
        this.toastQueue = toastQueue;
    }

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            try {
                TimeUnit.MILLISECONDS.sleep(100 + rand.nextInt(500));
                Toast toast = new Toast(count++);
                System.out.println(toast);
                toastQueue.put(toast);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Butterer implements Runnable {
    private ToastQueue dryQueue, butterQueue;

    public Butterer(ToastQueue dryQueue, ToastQueue butterQueue) {
        super();
        this.dryQueue = dryQueue;
        this.butterQueue = butterQueue;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                Toast toast = dryQueue.take();
                toast.butter();
                System.out.println(toast);
                butterQueue.put(toast);
            }
        } catch (Exception e) {
            System.out.println("Butterer interrupt");
        }
    }
}

class Jammer implements Runnable {
    private ToastQueue butterQueue, finishQueue;

    public Jammer(ToastQueue butterQueue, ToastQueue finishQueue) {
        super();
        this.butterQueue = butterQueue;
        this.finishQueue = finishQueue;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                Toast toast = butterQueue.take();
                toast.jam();
                System.out.println(toast);
                finishQueue.put(toast);
            }
        } catch (Exception e) {
            System.out.println("Jammer interrupted");
        }
    }
}

class Eater implements Runnable {
    private ToastQueue finishQueue;
    private int counter = 0;

    public Eater(ToastQueue finishQueue) {
        super();
        this.finishQueue = finishQueue;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                Toast toast = finishQueue.take();
                if (toast.getId() != counter++ || toast.getStatus() != Toast.Status.JAMMED) {
                    System.out.println(">>>>>Error:" + toast);
                    System.exit(1);
                }else{
                    System.out.println("Chomp!"+toast);
                }
            }
        } catch (Exception e) {
            System.out.println("Eater interrupted");
        }
    }
}

public class ToastOMatic {

    public static void main(String[] args) throws InterruptedException {
        ToastQueue toastQueue = new ToastQueue(),
                butterQueue = new ToastQueue(), 
                finishQueue = new ToastQueue();
        ExecutorService exec=Executors.newCachedThreadPool();
        exec.execute(new Toaster(toastQueue));
        exec.execute(new Butterer(toastQueue, butterQueue));
        exec.execute(new Jammer(butterQueue, finishQueue));
        exec.execute(new Eater(finishQueue));
        TimeUnit.SECONDS.sleep(5);
        exec.shutdownNow();
        System.exit(0);
    }

}
