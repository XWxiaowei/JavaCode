package com.jay.springAOP.DynamicAgent;

import com.jay.springAOP.DynamicAgent.model.User;

import java.util.List;

/**
 * Created by xiang.wei on 2017/8/16.
 */
public interface IuserService {

    List<User>  findAllUser();
    int deleteUser(int id);
    int insertUser(User user);
}
