/*
 * Project: DesignPatterns
 * 
 * File Created at 2016年9月30日
 * 
 * Copyright 2016 CMCC Corporation Limited.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * ZYHY Company. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license.
 */
package com.memento;

/**
 * @Type Client.java
 * @Desc 
 * @author  xiang.wei
 * @date 2016年9月30日 下午2:23:14
 * @version 
 */
public class Client {

    public static void main(String[] args) {
        Originator originator = new Originator();
        originator.state = "On";
        originator.show();

        Caretaker caretaker = new Caretaker();
        caretaker.memento=originator.createMemento();
        originator.state="Off";
        originator.show();
        
        originator.setMemento(caretaker.memento);
        originator.show();
        
    }

}
