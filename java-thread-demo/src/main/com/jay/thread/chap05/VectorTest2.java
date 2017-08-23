package com.jay.thread.chap05;

import java.util.Vector;
import java.util.concurrent.CountDownLatch;

/**
 * Created by xiang.wei on 2017/8/23
 */
public class VectorTest2 {
    final static CountDownLatch cdOrder = new CountDownLatch(1);//指挥官命令，只有一个指挥官
    final static CountDownLatch cdAnswer = new CountDownLatch(1000);//士兵

    public static Object getList(Vector list) throws InterruptedException {
        int lastIndex = list.size() - 1;
        return list.get(lastIndex);
    }

    public static void deleteLast(Vector list) throws InterruptedException {
        int lastIndex = list.size() - 1;
        list.remove(lastIndex);
    }

    public static void main(String[] args) {
        Vector<String> stringVc = new Vector<>();
        stringVc.add("1");
        stringVc.add("2");

        new Thread(new Runnable() {
            @Override
            public void run() {
                //制造了死循环
                while (true) {
                    try {
                        getList(stringVc);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        break;
                    }
                }
            }
        }, "Get").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        deleteLast(stringVc);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        break;
                    }
                }
            }
        }, "Delete").start();

    }
}
