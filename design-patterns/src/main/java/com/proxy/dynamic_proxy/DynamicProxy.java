package com.proxy.dynamic_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author xiang.wei
 * @create 2018/5/28 13:21
 */
public class DynamicProxy implements InvocationHandler {
    private Object target;

    public DynamicProxy(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        perHandle();
        method.invoke(target,args);
        nextHandle();
        return null;
    }

    /**
     * 代理类前置处理
     */
    public void perHandle() {
        System.out.println("代理类前置处理");
    }

    /**
     * 代理类后置处理
     */
    public void nextHandle() {
        System.out.println("代理类后置处理");
    }
}
