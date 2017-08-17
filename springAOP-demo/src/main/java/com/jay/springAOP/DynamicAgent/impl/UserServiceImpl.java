package com.jay.springAOP.DynamicAgent.impl;

import com.jay.springAOP.DynamicAgent.IuserService;
import com.jay.springAOP.DynamicAgent.model.User;

import java.util.List;

/**
 * 真实对象
 * Created by xiang.wei on 2017/8/16.
 */
public class UserServiceImpl implements IuserService {
    public List<User> findAllUser() {
        System.out.println("-----查询用户------");
        return null;
    }

    public int deleteUser(int id) {
        System.out.println("------删除用户----");
        return 0;
    }

    public int insertUser(User user) {
        System.out.println("----新增用户-------");
        return 0;
    }
}
