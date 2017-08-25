package com.jay.thread.chap07;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Created by xiang.wei on 2017/8/25
 */
public class TimedRun {
    private final static ExecutorService taskExec = Executors.newCachedThreadPool();

    public static void timedRun(Runnable r,
                                long timeout,
                                TimeUnit unit) {
        Future<?> task = taskExec.submit(r);
        try {
            task.get(timeout, unit);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        } finally {
            //如果任务已经结束，那么执行取消操作也不会带来任何影响
//            如果任务正在运行，那么将会中断
            task.cancel(true);
        }
    }
}
