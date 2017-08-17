package com.jay.thread;

import com.jay.thread.chap01.Sequence;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by xiang.wei on 2017/8/17.
 */
public class SequenceTest {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newFixedThreadPool(100);
        ExecutorService exec1 = Executors.newFixedThreadPool(100);
        long startTime = System.currentTimeMillis();
        System.out.println("开始时间:"+System.currentTimeMillis());
        Runnable runnable = new SequenceRunnable();
        for (int i = 0; i < 100; i++) {
            exec.submit(runnable);
            exec1.submit(runnable);
        }
        System.out.println("总耗时:"+(System.currentTimeMillis()-startTime));
        //结束线程池
        exec.shutdown();
        exec1.shutdown();
    }
}

class SequenceRunnable implements Runnable {
    Sequence sequence = new Sequence();

    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "/" + sequence.getNext());
        }
    }
}