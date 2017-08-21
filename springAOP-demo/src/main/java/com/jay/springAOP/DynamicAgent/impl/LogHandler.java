package com.jay.springAOP.DynamicAgent.impl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理对象
 * Created by xiang.wei on 2017/8/16.
 */
public class LogHandler implements InvocationHandler {
    public Object targetObject;

    public Object createProxy(Object targetObject){
        this.targetObject = targetObject;
        return Proxy.newProxyInstance(targetObject.getClass().getClassLoader(),
                targetObject.getClass().getInterfaces(), this);
    }
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object obj=null;
        try {
            startLog();
            obj = method.invoke(targetObject,args);
            endLog();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return obj;
    }
    public void startLog() {
        System.out.println("-------开始操作-----");
    }

    public void endLog() {
        System.out.println("-------结束操作-----");
    }
}
