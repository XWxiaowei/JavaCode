package com.proxy.dynamic_proxy;

import com.proxy.static_proxy.ISubject;

/**
 * Created by xiang.wei on 2018/5/28
 *
 * @author xiang.wei
 */
public class RealSubject implements ISubject {
    @Override
    public void buyCosmetics() {
        System.out.println("买某种进口化妆品");
    }
}
