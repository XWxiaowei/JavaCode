/*
 * Project: DesignPatterns
 * 
 * File Created at 2016年9月29日
 * 
 * Copyright 2016 CMCC Corporation Limited.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * ZYHY Company. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license.
 */
package com.singleton;

/**
 * @Type Client.java
 * @Desc 
 * @author  xiang.wei
 * @date 2016年9月29日 下午7:10:07
 * @version 
 */
public class Client {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        LazySingleton instance1= LazySingleton.getInstance();
        LazySingleton instance2= LazySingleton.getInstance();
        LazySingleton instance3= LazySingleton.getInstance();
        LazySingleton instance4= LazySingleton.getInstance();
        System.out.println("懒汉式所用时："+(System.currentTimeMillis()-startTime)+"ms");
        if (instance1.equals(instance2)) {
            System.out.println("懒汉式两个实例相同");
        }
        long startTime1 = System.currentTimeMillis();
        HungrySingleton singleton1 = HungrySingleton.getInstance();
        HungrySingleton singleton2 = HungrySingleton.getInstance();
        HungrySingleton singleton3 = HungrySingleton.getInstance();
        HungrySingleton singleton4 = HungrySingleton.getInstance();
        System.out.println("饿汉式所用时："+(System.currentTimeMillis()-startTime1)+"ms");
        if (singleton1.equals(singleton2)) {
            System.out.println("饿汉式两个实例相同");
        }


//       new Thread(new Runnable() {
//            @Override
//            public void run() {
//                LazySingleton_two lazySingleton_two1 = LazySingleton_two.getInstance();
//            }
//        },"线程1").start();
//       new Thread(new Runnable() {
//            @Override
//            public void run() {
//                LazySingleton_two lazySingleton_two2 = LazySingleton_two.getInstance();
//            }
//        }, "线程2").start();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                LazySingleton_two lazySingleton_two2 = LazySingleton_two.getInstance();
//            }
//        }, "线程3").start();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                LazySingleton_two lazySingleton_two2 = LazySingleton_two.getInstance();
//            }
//        }, "线程4").start();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                LazySingleton_two lazySingleton_two2 = LazySingleton_two.getInstance();
//            }
//        }, "线程5").start();

        long startTime2 = System.currentTimeMillis();
        ClassInnerClassSingleton innerClassSingleton1 = ClassInnerClassSingleton.getInstance();
        ClassInnerClassSingleton innerClassSingleton2 = ClassInnerClassSingleton.getInstance();
        ClassInnerClassSingleton innerClassSingleton3 = ClassInnerClassSingleton.getInstance();
        ClassInnerClassSingleton innerClassSingleton4 = ClassInnerClassSingleton.getInstance();
        System.out.println("类级内部类方式所用时："+(System.currentTimeMillis()-startTime2)+"ms");

        long startTime3 = System.currentTimeMillis();
        LazySingleton_two singleton_two1 = LazySingleton_two.getInstance();
        LazySingleton_two singleton_two2 = LazySingleton_two.getInstance();
        LazySingleton_two singleton_two3 = LazySingleton_two.getInstance();
        LazySingleton_two singleton_two4 = LazySingleton_two.getInstance();
        System.out.println("双重加锁所用时："+(System.currentTimeMillis()-startTime3)+"ms");
        if (singleton_two1.equals(singleton_two2)) {
            System.out.println("双重加锁两个实例相同");
        }

    }

}


