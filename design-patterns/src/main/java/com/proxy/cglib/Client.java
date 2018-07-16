package com.proxy.cglib;

/**
 * @author xiang.wei
 * @create 2018/5/28 15:19
 */
public class Client {
    public static void main(String[] args) {
        //目标对象
        RealSubject realSubject = new RealSubject();
        //代理对象
        RealSubject proxy = (RealSubject) new ProxyFactory(realSubject).getProxyInstance();
        proxy.buyCosmetics();
    }
}
