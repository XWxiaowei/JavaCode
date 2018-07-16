package com.proxy.dynamic_proxy;

import java.lang.reflect.Proxy;

/**
 * @author xiang.wei
 * @create 2018/5/28 13:30
 */
public class Client {
    public static void main(String[] args) {
        ISubject target =  new RealSubject();
        //生成真实对象的代理
        DynamicProxy handler = new DynamicProxy(target);
        // 动态生成代理实例（HouseHold代理实例），代理支持的接口由初始化参数（第二个）指定，代理实例处理操作所调用的 handler 由第三个参数指定
        ISubject proxy1 = (ISubject) Proxy.newProxyInstance(RealSubject.class.getClassLoader(),RealSubject.class.getInterfaces(),handler);
        proxy1.buyCosmetics(); // 执行客户需要进行的行为操作，动态生成的代理实例直接调用指定 handler 的 invoke 方法

        ProxyFactory proxyFactory = new ProxyFactory(target);
        ISubject proxy = (ISubject) proxyFactory.getProxyInstance();
        proxy.buyCosmetics();
    }
}
