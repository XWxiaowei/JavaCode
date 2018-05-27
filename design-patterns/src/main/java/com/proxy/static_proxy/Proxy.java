package com.proxy.static_proxy;

/**
 * Created by xiang.wei on 2018/5/28
 *
 * @author xiang.wei
 */
public class Proxy implements ISubject {
    //接收目标对象
    private ISubject target;

    public Proxy(ISubject iSubject) {
        this.target = iSubject;
    }

    @Override
    public void buyCosmetics() {
        target.buyCosmetics();
    }
}
