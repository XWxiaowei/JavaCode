package com.jay.thread.chap08;

import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

/**
 *
 * Created by xiang.wei on 2017/8/27
 */
public class TimingThreadPool extends ThreadPoolExecutor {
    private final Logger logger = Logger.getLogger("TimingThreadPool");

    private final ThreadLocal<Long> startTime = new ThreadLocal<>();
    private final AtomicLong numTask = new AtomicLong();   //记录已处理的任务数
    private final AtomicLong totalTime = new AtomicLong();  //记录总的处理时间

    public TimingThreadPool() {
        super(1, 1, 0L, TimeUnit.SECONDS, null);
    }

    @Override
    protected void beforeExecute(Thread t, Runnable r) {
        super.beforeExecute(t, r);
        logger.fine(String.format("Thread %s: start %s",t,r));
        startTime.set(System.nanoTime());
    }

    @Override
    protected void afterExecute(Runnable r, Throwable t) {
        try {
            long endTime = System.nanoTime();
            long taskTime = endTime - startTime.get();
            numTask.incrementAndGet();  //以一个当前值原子递增。
            totalTime.addAndGet(taskTime); //原子地将给定值添加到当前值。
            logger.fine(String.format("Thread %s: start %s,time=%dns",t,r,taskTime));
        } finally {
            super.afterExecute(r, t);
        }
    }

    @Override
    protected void terminated() {
        try {
            logger.info(String.format("Terminated: avg time=%dns",
                    totalTime.get() / numTask.get()));

        } finally {
            super.terminated();
        }
    }
}
