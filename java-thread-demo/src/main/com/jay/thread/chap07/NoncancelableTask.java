package com.jay.thread.chap07;

import java.util.concurrent.BlockingQueue;

/**
 * 不可取消的任务在退出前恢复中断
 * Created by xiang.wei on 2017/8/25
 */
public class NoncancelableTask {
    public Task getNextTask(BlockingQueue<Task> queue) {
        boolean interrupted = false;
        try {
            while (true) {
                try {
                    return queue.take();
                } catch (InterruptedException e) {
                    interrupted = true;
                }
            }
        } finally {
            if (interrupted) {
                Thread.currentThread().interrupt();
            }

        }
    }

    interface Task {
    }
}

