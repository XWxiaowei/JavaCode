package com.jay.springAOP.staticAgent.impl;

import com.jay.springAOP.staticAgent.IuserService;
import com.jay.springAOP.staticAgent.model.User;

import java.util.List;

/**
 * 代理对象
 * Created by xiang.wei on 2017/8/16.
 */
public class UserServiceProxyImpl implements IuserService {
    private IuserService iuserService;

    public UserServiceProxyImpl(IuserService iuserService) {
        this.iuserService = iuserService;
    }

    public List<User> findAllUser() {
        startLog();
        List<User> users = iuserService.findAllUser();
        endLog();
        return users;
    }

    public int deleteUser(int id) {
        startLog();
        int result = iuserService.deleteUser(id);
        endLog();
        return result;
    }

    public int insertUser(User user) {
        startLog();
        int result = iuserService.insertUser(user);
        endLog();
        return result;
    }

    public void startLog() {
        System.out.println("-------开始操作-----");
    }

    public void endLog() {
        System.out.println("-------结束操作-----");
    }

}
