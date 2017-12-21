/*
 * Project: ThreadLearn
 * 
 * File Created at 2016年12月9日
 * 
 * Copyright 2016 CMCC Corporation Limited.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * ZYHY Company. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license.
 */
package com.thread.currency;

/**
 * @Type LiftOff.java
 * @Desc  定义任务
 * @author  xiang.wei
 * @date 2016年12月9日 下午3:00:49
 * @version 
 */
public class LiftOff  implements Runnable{
    protected int countDown=10;
    private static int taskCount=0;
    private final int id=taskCount++;   //标识符id可以区分任务的多个实例
    
    public LiftOff(int countDown) {
        super();
        this.countDown = countDown;
    }
    public LiftOff() {
        
    }
    public String status() {
        return null;
    }
    @Override
    public void run() {
        while (countDown-->0) {
            System.out.println(status());
        }
    }

}


