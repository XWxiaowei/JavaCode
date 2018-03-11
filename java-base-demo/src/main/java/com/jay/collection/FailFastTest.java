package com.jay.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by xiang.wei on 2018/3/4
 *
 * @author xiang.wei
 */
public class FailFastTest {
    /**
     *
     */
    private static List<String> globalList = new ArrayList<String>();


    /**
     *  线程one,two,three同时启动，线程one向globalList中添加元素0，1，2，3，4，5，然后遍历打印
     *  线程two 与此同时也向globalList中添加元素10，11，12，13，14，15，然后遍历打印，
     *  线程three 同时也在移除globalList中元素0，1，2，3，4，5，然后遍历打印
     *
     */
    public static void main(String[] args) {
        new ThreadOne().start();
        new ThreadTwo().start();
        new ThreadThree().start();
    }

    /**
     * 向globalList中添加元素0，1，2，3，4，5，然后遍历打印
     */
    private static class ThreadOne extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 6; i++) {
                globalList.add(String.valueOf(i));
                printAll(globalList);
            }
        }
    }

    /**
     *  向globalList中添加元素10，11，12，13，14，15，然后遍历打印
     */
    private static class ThreadTwo extends Thread {
        @Override
        public void run() {
            for (int i = 10; i < 16; i++) {
                globalList.add(String.valueOf(i));
                printAll(globalList);
            }
        }
    }

    /**
     * 移除globalList中元素0，1，2，3，4，5，然后遍历打印
     */
    private static class ThreadThree extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 6; i++) {
                globalList.remove(String.valueOf(i));
                printAll(globalList);
            }
        }
    }

    private static void printAll(List<String> testList) {
//        Iterator<String> testIter = testList.iterator();
//        while (testIter.hasNext()) {
//            System.out.println((testIter.next()));
//        }
        for (String s : testList) {
            System.out.println(s);
        }

    }
}
