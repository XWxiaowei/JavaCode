package com.jay.thread.chap07;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.Executors.newScheduledThreadPool;

/**
 * 在专门的线程中中断任务
 * 在启动任务线程之后，timedRun将执行一个现实的join方法。在join返回后，
 * 它将检查任务中是否有异常抛出，如果有的话，则会在调用timedRun的线程中再次抛出
 * 异常。由于Throwable将在两个线程之间共享，因此该变量被声明为volatile类型，从而
 * 确保安全地将其从任务线程发布到timedRun线程
 * Created by xiang.wei on 2017/8/25
 */
public class TimeRun2 {
    private static final ScheduledExecutorService cancelExec = newScheduledThreadPool(1);

    public static void timedRun(final Runnable r,
                                long timeout,
                                TimeUnit unit) throws InterruptedException {
        class RethrowableTask implements Runnable {
            private volatile Throwable t;

            @Override
            public void run() {
                try {
                    r.run();
                } catch (Throwable t) {
                    this.t = t;
                }
            }

            void rethrow() {
                if (t != null) {
//                    throw launderThrowable(t);
                }
            }
        }

        RethrowableTask task = new RethrowableTask();
        final Thread taskThread = new Thread(task);
        cancelExec.schedule(new Runnable() {
            @Override
            public void run() {
                taskThread.interrupt();
            }
        },timeout,unit);
        taskThread.join(unit.toMillis(timeout));
        task.rethrow();
    }

}
