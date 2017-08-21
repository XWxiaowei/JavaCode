package com.jay.springAOP.staticAgent;

import com.jay.springAOP.staticAgent.impl.UserServiceImpl;
import com.jay.springAOP.staticAgent.impl.UserServiceProxyImpl;
import com.jay.springAOP.staticAgent.model.User;

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
