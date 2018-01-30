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
        Singleton instance1=Singleton.getInstance();
        Singleton instance2=Singleton.getInstance();
        if (instance1.equals(instance2)) {
            System.out.println("两个实例相同");
        }
    }

}


