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
package com.Bridge;

/**
 * @Type Client.java
 * @Desc 
 * @author  xiang.wei
 * @date 2016年9月29日 下午7:34:06
 * @version 
 */
public class Client {

    public static void main(String[] args) {
        Abstraction ab=new RefinedAbstraction(new ConcreteImplementsA());
        Abstraction ac=new RefinedAbstraction(new ConcreteImplementsB());
        ab.operation();
        ac.operation();
    }

}


