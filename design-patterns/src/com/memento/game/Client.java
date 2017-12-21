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
package com.memento.game;

/**
 * @Type Client.java
 * @Desc 
 * @author  xiang.wei
 * @date 2016年9月30日 下午2:23:14
 * @version 
 */
public class Client {

    public static void main(String[] args) {
        //大战之前
        GameRole gameRole=new GameRole();
        gameRole.setInitState();
        gameRole.display();
        
      //保存进度
        RoleStateManager roleStateManager=new RoleStateManager();
        roleStateManager.roleState=gameRole.setRoleState();
        //大战损耗严重
        gameRole.figth();
        gameRole.display();
        
        //恢复初始状态
        gameRole.restart(roleStateManager.getRoleState());
        gameRole.display();
    }

}
