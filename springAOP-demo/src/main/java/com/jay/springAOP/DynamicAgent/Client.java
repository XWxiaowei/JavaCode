package com.jay.springAOP.DynamicAgent;

import com.jay.springAOP.DynamicAgent.impl.UserServiceImpl;
import com.jay.springAOP.DynamicAgent.impl.UserServiceProxyImpl;
import com.jay.springAOP.DynamicAgent.model.User;

/**
 * Created by xiang.wei on 2017/8/16.
 */
public class Client {
    public static void main(String[] args) {
        IuserService iuserService = new UserServiceProxyImpl(new UserServiceImpl());
        iuserService.findAllUser();
        iuserService.deleteUser(1);
        iuserService.insertUser(new User());

    }
}
