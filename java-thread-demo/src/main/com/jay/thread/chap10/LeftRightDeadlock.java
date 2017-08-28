package com.jay.thread.chap10;

/**
 * 容易发生死锁！锁顺序死锁
 * Created by xiang.wei on 2017/8/28
 */
public class LeftRightDeadlock {
    private final Object left = new Object();
    private final Object right = new Object();

    public void leftRight() {
        synchronized (left) {
            synchronized (right) {
                doSomething();
            }
        }
    }

    public void rightLeft() {
        synchronized (right) {
            synchronized (left) {
                doSomethingElse();
            }
        }
    }

    public void doSomething() {
    }

    public void doSomethingElse() {

    }
}
