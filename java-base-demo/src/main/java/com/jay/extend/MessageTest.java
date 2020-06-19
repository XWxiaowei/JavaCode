package com.jay.extend;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;


public class MessageTest {
    public static void main(String[] args) {
        List<String> batchMessageList = new ArrayList<>();
        //初始化测试数据
        for (int i = 0; i < 110; i++) {
            String message="消息"+i;
            batchMessageList.add(message);
        }
        //1. 定义四个任务，每个任务发送25条
        //2. 然后归并结果
        ForkJoinPool forkJoinPool = new ForkJoinPool(5);
        //超过100条就只发送前100条
        if (batchMessageList.size() > 100) {
            batchMessageList = batchMessageList.subList(0, 100);
        }
        long startTime = System.currentTimeMillis();
        SendTask sendTask = new SendTask(0,batchMessageList.size(),batchMessageList);
        forkJoinPool.invoke(sendTask);
        System.out.println("***********消息发送总耗时="+(System.currentTimeMillis()-startTime));
    }

    //单条发送的接口
    public static void send(String message)  {
        try {
            Thread.sleep(2);
            System.out.println("***********发送了="+message);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void batchSend(int start, int end, List<String> messageList) {
        for (int i = start; i < end; i++) {
            send(messageList.get(i));
        }
    }

    static class SendTask extends RecursiveAction {
        private int start;
        private int end;
        private List<String> list;

        public SendTask(int start, int end, List<String> list) {
            this.start = start;
            this.end = end;
            this.list = list;
        }

        @Override
        protected void compute() {
            if (start > end) {
                return;
            }
            if (end - start <= 20) {
                 batchSend(start, end,list);
            } else {
                int mid = (start + end) / 2;
                SendTask rightTask = new SendTask(start, mid,list);
                SendTask leftTask = new SendTask(mid + 1, end, list);
                invokeAll(rightTask, leftTask);
                leftTask.join();
                rightTask.join();

            }

        }
    }
}
