package com.jay.threadlocal;

/**
 * @author xiang.wei
 * @date 2020/2/19 10:40 AM
 */
public class ThreadLocalTest {
    public static void main(String[] args) {
        ThreadLocal<String> threadLocal = new ThreadLocal<>();
        try {
            threadLocal.set("张三");
        } catch (Exception e) {
            threadLocal.remove();
        }

        new Thread(()->{
            threadLocal.set("李四");
            System.out.println("*******"+Thread.currentThread().getName()+"获取到的数据"+threadLocal.get());
        },"线程1").start();
        new Thread(()->{
            threadLocal.set("王二");
            System.out.println("*******"+Thread.currentThread().getName()+"获取到的数据"+threadLocal.get());
        },"线程2").start();
        new Thread(()->{
            System.out.println("*******"+Thread.currentThread().getName()+"获取到的数据"+threadLocal.get());
        },"线程3").start();
        System.out.println("线程=" + Thread.currentThread().getName() + "获取到的数据=" + threadLocal.get());
    }
}
