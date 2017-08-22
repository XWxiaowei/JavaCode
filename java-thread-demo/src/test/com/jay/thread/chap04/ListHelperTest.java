package com.jay.thread.chap04;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by xiang.wei on 2017/8/22
 */
@RunWith(JUnit4.class)
public class ListHelperTest {
    private final ExecutorService exec = Executors.newFixedThreadPool(100);
    final  CountDownLatch cdOrder = new CountDownLatch(1);//指挥官命令，只有一个指挥官
    final  CountDownLatch cdAnswer = new CountDownLatch(3); //战士命令，有100个战士

    @Test
    public void putIfAbsent() throws Exception {
        BadListHelper<Integer> badListHelper = new BadListHelper<>();
        for (int i = 0; i <3; i++) {
            Integer myInt = new Integer(i);
            int finalin=i;
            Runnable runnable=new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println("badListHelper的线程"+Thread.currentThread().getName()+"正准备接受命令");
                        cdOrder.await(); //战士们都处于等待命令状态
                        System.out.println("badListHelper的线程"+Thread.currentThread().getName()+"已收到命令");
                        badListHelper.list.add(myInt);
                        badListHelper.putIfAbsent(myInt);
                        System.out.println("badListHelper的"+badListHelper.list.get(finalin));
                        System.out.println("badListHelper的线程"+Thread.currentThread().getName()+"已完成命令");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }finally {
                        cdAnswer.countDown();
                    }
                }
            };
            exec.submit(runnable);
        }
        System.out.println("badListHelper的线程"+Thread.currentThread().getName()+"正准备发布命令");
        cdOrder.countDown();
        badListHelper.list.add(new Integer(0));
        System.out.println("badListHelper特殊的"+badListHelper.list.get(0));
        System.out.println("badListHelper的线程"+Thread.currentThread().getName()+"已经发布命令");
        cdAnswer.await();//命令发布之后，指挥官处于等待状态，直到所有命令完成
        System.out.println("badListHelper的线程"+Thread.currentThread().getName()+"已收到所有命令完成结果");

    }

    @Test
    public void putIfAbsent1() throws Exception {
        GoodListHelper<Integer> goodListHelper = new GoodListHelper<>();
        for (int i = 0; i <3 ; i++) {
            Integer myInt = new Integer(i);
            int finalIn=i;
            Runnable runnable=new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println("goodListHelper的线程"+Thread.currentThread().getName()+"正准备接受命令");
                        cdOrder.await(); //战士们都处于等待命令状态
                        goodListHelper.putIfAbsent(myInt);
                        System.out.println("goodListHelper的"+goodListHelper.list.get(finalIn));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }finally {
                        cdAnswer.countDown();
                    }
                }
            };
            exec.submit(runnable);
        }
        cdOrder.countDown();
        goodListHelper.list.add(new Integer(0));
        System.out.println("goodListHelper特殊的"+goodListHelper.list.get(0));
        cdAnswer.await();//命令发布之后，指挥官处于等待状态，直到所有命令完成
        System.out.println("线程"+Thread.currentThread().getName()+"已收到所有命令完成结果");

    }


}