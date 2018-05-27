package com.proxy.static_proxy;

/**
 * Created by xiang.wei on 2018/4/23
 *
 * @author xiang.wei
 */
public class Client {
    public static void main(String[] args) {
        ISubject realSubject = new RealSubject();
        Proxy proxy = new Proxy(realSubject);
        proxy.buyCosmetics();
    }
}
