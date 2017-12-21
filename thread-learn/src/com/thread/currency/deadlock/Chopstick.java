/*
 * Project: ThreadLearn
 * 
 * File Created at 2016年12月15日
 * 
 * Copyright 2016 CMCC Corporation Limited.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * ZYHY Company. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license.
 */
package com.thread.currency.deadlock;

/**
 * @Type Chopstick.java
 * @Desc 筷子类
 * 模拟事件：哲学家就餐问题是一个经典的死锁例证。
 * 5个哲学家，5根筷子，他们围坐在桌子周边，每人之间放一根筷子。
 * 当哲学家就餐的时候必须同时得到左边和右边的筷子。
 * @author  xiang.wei
 * @date 2016年12月15日 下午2:46:12
 * @version 
 */
public class Chopstick {
    private boolean taken = false; //拿筷子标志

    public synchronized void take() throws InterruptedException {
        while (taken) {
            wait();
        }
        taken = true;
    }

    public synchronized void drop() {
        taken = false;
        notifyAll();
    }

}
