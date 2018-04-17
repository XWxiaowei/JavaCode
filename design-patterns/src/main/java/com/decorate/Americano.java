package com.decorate;

/**
 * 美式咖啡类
 * @author xiang.wei
 * @create 2018/4/11 13:50
 */
public class Americano extends Coffee {
    @Override
    public String getCoffeeInfo() {
        return "美式咖啡";
    }

    @Override
    public int cost() {
        return 25;
    }
}
