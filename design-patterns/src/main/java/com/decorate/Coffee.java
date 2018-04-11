package com.decorate;

/**
 * 抽象咖啡类
 *
 * @author xiang.wei
 * @create 2018/4/10 19:44
 */
public abstract class Coffee {
    private String coffeeInfo = "普通咖啡";

    public String getCoffeeInfo() {
        return coffeeInfo;
    }

    public abstract int cost();
}
