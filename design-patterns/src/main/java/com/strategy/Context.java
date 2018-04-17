package com.strategy;

/**
 * Created by xiang.wei on 2018/4/18
 *
 * @author xiang.wei
 */
public class Context {
    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public void contextInterface() {
        strategy.algorithmlnterface();
    }
}
