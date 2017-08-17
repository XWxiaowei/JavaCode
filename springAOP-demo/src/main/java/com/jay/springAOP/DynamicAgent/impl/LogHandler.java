package com.jay.springAOP.DynamicAgent.impl;

import com.jay.springAOP.DynamicAgent.IuserService;
import com.jay.springAOP.DynamicAgent.model.User;

import java.util.List;

/**
 * 代理对象
 * Created by xiang.wei on 2017/8/16.
 */
public class LogHandler implements IuserService {

    public void startLog() {
        System.out.println("-------开始操作-----");
    }

    public void endLog() {
        System.out.println("-------结束操作-----");
    }

}
