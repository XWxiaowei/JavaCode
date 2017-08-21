package com.jay.springAOP.DynamicAgent;

import com.jay.springAOP.DynamicAgent.impl.LogHandler;
import com.jay.springAOP.DynamicAgent.impl.UserServiceImpl;
import com.jay.springAOP.DynamicAgent.model.User;

/**
 * Created by xiang.wei on 2017/8/16.
 */
public class Client {
    public static void main(String[] args) {
        LogHandler logHandler = new LogHandler();
        IuserService iuserService = (IuserService) logHandler.createProxy(new UserServiceImpl());
        iuserService.findAllUser();
        iuserService.deleteUser(1);
        iuserService.insertUser(new User());
    }
}
