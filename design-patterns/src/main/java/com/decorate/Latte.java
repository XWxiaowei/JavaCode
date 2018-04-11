package com.decorate;

/**
 * 拿铁类
 *
 * @author xiang.wei
 * @create 2018/4/11 13:49
 */
public class Latte extends Coffee {
    @Override
    public String getCoffeeInfo() {
        return "拿铁";
    }

    @Override
    public int cost() {
        return 30;
    }
}
